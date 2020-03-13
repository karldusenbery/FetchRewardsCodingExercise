package dev.dusenbery.fetchrewardscodingchallenge

import android.content.Context
import com.google.gson.Gson

// In this class definition I had to take out the param:
// private val jsonString: String
// because it's not used...yet.

class ItemDataManager(private val context: Context) {

    // Returns an ArrayList of Items based off of parsed JSON
    fun readItems(): ArrayList<Item> {

        // Initialize the ArrayList to be returned
        val itemsList = ArrayList<Item>()

        // Example JSON
        val json = """{"id": 684, "listId": "1", "name" : "Item 684"}"""

        // Uses the GSON library to convert parsed JSON to objects of the Item model class
        val gson = Gson()
        val item: Item = gson.fromJson(json, Item::class.java)

        // Adds the item object to the ArrayList
        itemsList.add(item)

        // Returns the ArrayList of Item objects
        return itemsList
    }
}