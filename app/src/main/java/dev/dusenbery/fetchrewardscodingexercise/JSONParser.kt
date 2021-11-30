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


    /*
    Parse JSON data
     */
    private fun parse(): Boolean {
        try {
            val ja = JSONArray(jsonData)
            var jo: JSONObject

            items.clear()
            var item: Item

            for (i in 0 until ja.length()) {
                jo = ja.getJSONObject(i)

                val id = jo.getInt("id")
                val name = jo.getString("name")
                val listId = jo.getInt("listId")

                item = Item(id,name,listId)

                //Filter out any items where "name" is blank or null.
                if (name.isBlank())
                    //Don't add this Item to the ArrayList of Item objects
                else
                    //Add this Item to the ArrayList of Item objects
                    items.add(item)
            }

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
