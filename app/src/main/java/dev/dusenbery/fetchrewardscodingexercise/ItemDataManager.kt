/**
 *  Here is a class to manage the parsing of JSON
 *  as well as using the GSON library to convery each JsonObject to a Item object from the Item model class
 */
package dev.dusenbery.fetchrewardscodingexercise

import android.content.Context
import com.google.gson.Gson

class ItemDataManager(private val context: Context) {

    var jsonString: String = """{"id": 000, "listId": 0, "name": "name"}"""

    // Returns an ArrayList of Items based off of parsed JSON
    fun readItems(): ArrayList<Item> {

        // Initialize the ArrayList to be returned
        val itemsList = ArrayList<Item>()

        // Uses the GSON library to convert parsed JSON to objects of the Item model class
        val gson = Gson()
        val item: Item = gson.fromJson(jsonString, Item::class.java)

        // Adds the item object to the ArrayList
        itemsList.add(item)

        // Returns the ArrayList of Item objects
        return itemsList
    }
}