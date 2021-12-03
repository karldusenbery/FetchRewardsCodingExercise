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

    private var newList = ArrayList<Item>()
    private var itemsWithAlistIdof4 = ArrayList<Item>()

    /*
    Parse JSON data
     */
    private fun parse(): Boolean {
        try {
            val ja = JSONArray(jsonData)
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

            //sorts filteredItems ArrayList by listId, returns a List type.
            filteredItems.groupingBy { it.listId }.eachCount()
            var itemsSortedByListIdList = filteredItems.sortedWith(compareBy({ it.listId }))

            itemsSortedByListId.clear()
            //adds Item objects from the itemsSortedByListIdList List to an ArrayList of Item objects called itemsSortedByListId
            for (i in 0 until itemsSortedByListIdList.size) {
                item = itemsSortedByListIdList.get(i)

                val id = item.getItemId()
                val name = item.getItemName().toString()
                val listId = item.getItemListId()

                item = Item(id,name,listId)

                itemsSortedByListId.add(item)
            }

            //makes the newly sorted item list equal to the items ArrayList that gets displayed in the RecyclerView
            items = itemsSortedByListId


            //Creates a Map with a key of listId as the group number first, and ArrayLists in each mapped listId key.
            val itemsGroupedByItemIdMap = itemsSortedByListId.groupBy { it.listId }

            //prints an array of all listId(s), which are the keys in the itemsGroupedByItemIdMap Map
            //itemsGroupedByItemIdMap.keys returns a Set<Int>.
            println("itemsGroupedByItemIdMap.keys:      " + itemsGroupedByItemIdMap.keys)

            var howManyListIds = itemsGroupedByItemIdMap.keys.size
            println("howManyListIds?:  " + howManyListIds)

            //iterates through all listIds (in this case, there's 4)
            for (i in 1 until howManyListIds) {
                //iterates through all items with current listId of i
                for (j in 0 until itemsSortedByListId.size) {
                    ///// filters out only items with a listId == i
                    if (itemsSortedByListId[j].listId == i) {
                        println("itemsSortedByListId[j]" + itemsSortedByListId[j])
                        newList.add(itemsSortedByListId[j])
                        println("newList.size =    " + newList.size)
                    }
                }
                println("newList:      " + newList)
            }
            //items = newList

            ///// filters out only items with a listId == 4
            itemsWithAlistIdof4.clear()
            for (i in 0 until itemsSortedByListId.size) {
                if (itemsSortedByListId[i].listId == 4) {
                    itemsWithAlistIdof4.add(itemsSortedByListId[i])
                }
            }
            println("itemsWithAlistIdof4:      " + itemsWithAlistIdof4)








            /*
            //sorts itemsSortedByListId ArrayList by name, returns a List type.
            itemsSortedByListId.groupingBy { it.name }.eachCount()
            var itemsSortedByNameList = itemsSortedByListId.sortedWith(compareBy({ it.name }))

            itemsSortedByListIdAndThenName.clear()
            //adds Item objects from the itemsSortedByNameList List to an ArrayList of Item objects called itemsSortedByListIdAndThenName
            for (i in 0 until itemsSortedByNameList.size) {
                item = itemsSortedByNameList.get(i)

                val id = item.getItemId()
                val name = item.getItemName().toString()
                val listId = item.getItemListId()

                item = Item(id,name,listId)

                itemsSortedByListIdAndThenName.add(item)
            }


            //makes the newly sorted item list equal to the items ArrayList that gets displayed in the RecyclerView
            //items = itemsSortedByListIdAndThenName
            */



            // ---- end filtering and sorting logic -------- //
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
