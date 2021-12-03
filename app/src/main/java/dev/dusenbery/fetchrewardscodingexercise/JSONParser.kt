package dev.dusenbery.fetchrewardscodingexercise

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

@Suppress("DEPRECATION")

class JSONParser(private var c: Context?, private var jsonData: String, private var myRecyclerView: RecyclerView) : AsyncTask<Void, Void, Boolean>() {

    private lateinit var pd: ProgressDialog
    private var items = ArrayList<Item>()
    private var filteredItems = ArrayList<Item>()
    private var itemsSortedByListId = ArrayList<Item>()
    private var itemsSortedByListIdAndThenName = ArrayList<Item>()


    /*
    Parse JSON data
     */
    private fun parse(): Boolean {
        try {
            val ja = JSONArray(jsonData)
            println("Value of UNFILTERED JSONArray(jsonData).length():  " + ja.length().toString())
            var jo: JSONObject

            items.clear()
            var item: Item

            //adds Items from JSON data to an ArrayList of Item objects called filteredItems(after filtering out "null" and blank names
            for (i in 0 until ja.length()) {
                jo = ja.getJSONObject(i)

                val id = jo.getInt("id")
                val name = jo.getString("name")
                val listId = jo.getInt("listId")

                item = Item(id,name,listId)

                /*
                    Filter out any items where "name" is blank or null.
                 */
                if (name.isBlank() || name == "null"){
                    //Don't add this Item to the ArrayList of Item objects
                }
                else{
                    //Add this Item to the ArrayList of Item objects
                    filteredItems.add(item)
                }
            }
            println("Value of filteredItems.size:  " + filteredItems.size.toString())

            //makes the newly filtered item list equal to the items ArrayList that gets displayed in the RecyclerView
            //items = filteredItems


            //sorts filteredItems ArrayList by listId, returns a List type.
                println("filteredItems BEFORE sorting:  " + filteredItems.toString())
            filteredItems.groupingBy { it.listId }.eachCount()
            var itemsSortedByListIdList = filteredItems.sortedWith(compareBy({ it.listId }))
                println("items AFTER sorting by listId:  " + itemsSortedByListIdList.toString())

            println("Value of itemsSortedByListIdList.size:  " + itemsSortedByListId.size.toString())

            itemsSortedByListId.clear()
            //adds Item objects from the itemsSortedByListIdList List to an ArrayList of Item objects called itemsSortedByListId
            for (i in 0 until itemsSortedByListIdList.size) {
                item = itemsSortedByListIdList.get(i)

                val id = item.getItemId()
                val name = item.getItemName().toString()
                val listId = item.getItemListId()

                item = Item(id,name,listId)

                itemsSortedByListId.add(item)
                println("Value of ArrayList itemsSortedByListId [new line]:   " + itemsSortedByListId.toString())
            }

            //makes the newly sorted item list equal to the items ArrayList that gets displayed in the RecyclerView
            items = itemsSortedByListId

            // new I have a big ArrayList of List objects, sorted by listId

            // --------------- Other things I tried --------------------------------------------------------------------------------------------------------//


            //sorts items ArrayList
            //var sortedList = items.sortedWith(compareBy({ it.listId }))
            // for (item in sortedList) {
                //println("sortedList value:    " + sortedList.toString())
                //println("sortedList:  listid:    " + item.listId)
                //println("sortedList:  name:    " + item.name)
                //println("sortedList:  id:    " + item.id)
            //}

            //clears out current ArrayLis of items
                //println("itmes BEFORE clearing:  " + items.toString())
            //items.clear()
                //println("itmes AFTER clearing:  " + items.toString())

            //adds items back, but this time sorted by listId
            //for (i in 0 until items.size()) {

            //}



            //groups Items ArrayList by listId
            //items.groupingBy { it.listId }.eachCount()

            /*
            Creates a Map with a key of listId as the group number first, and ArrayLists in each mapped listId key.
            Type is Map<Int, List<Item>>
            Ex:
             */
            //val groupedItemsByItemId = items.groupBy { it.listId }
                //print statement for debugging
                //println("groupedItemsByItemId = " + groupedItemsByItemId.toString())

            /*
            Group Items by the Map's key which reprsents the listId into separate Lists
             */

            // First get a count of how many keys are in the Map
            //var mapKeyCountSize: Int = groupedItemsByItemId.count()
                //print statement for debugging
                //println("mapKeyCountSize = " + mapKeyCountSize.toString())

            //create a new List for each listId key of the Map
            //for (i in 0 until mapKeyCountSize){
                //var itemGroups = ArrayList<Item>(i)
                //print statement for debugging
                //println(itemGroups)

                /*
                attempting to make a new List for every listId group

                var itemGroup = List<Item>(groupedItemsByItemId[i].count())
                itemGroup = groupedItemsByItemId[i]
                //print statement for debugging
                println(itemGroup)

                 */

            //}
            // --------------- [end] Other things I tried --------------------------------------------------------------------------------------------------------//


            return true
        } catch (e: JSONException) {
            e.printStackTrace()
            return false
        }
    }
    override fun onPreExecute() {
        super.onPreExecute()

        pd = ProgressDialog(c)
        pd.setTitle("Parse JSON")
        pd.setMessage("Parsing...Please wait")
        pd.show()
    }

    override fun doInBackground(vararg voids: Void): Boolean? {
        return parse()
    }

    override fun onPostExecute(isParsed: Boolean?) {
        super.onPostExecute(isParsed)

        pd.dismiss()
        if (isParsed!!) {
            //BIND
            myRecyclerView.adapter = ItemListAdapter(c, items)
        } else {
            Toast.makeText(c, "Unable To Parse that data. ARE YOU SURE IT IS VALID JSON DATA? JsonException was raised. Check Log Output.", Toast.LENGTH_LONG).show()
            Toast.makeText(c, "THIS IS THE DATA WE WERE TRYING TO PARSE :  "+ jsonData, Toast.LENGTH_LONG).show()
        }
    }

}
