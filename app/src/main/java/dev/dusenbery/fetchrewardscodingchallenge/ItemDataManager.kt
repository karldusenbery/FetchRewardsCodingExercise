package dev.dusenbery.fetchrewardscodingchallenge

import android.content.Context
import com.google.gson.Gson

class ItemDataManager(private val context: Context) {

    fun readItems(): ArrayList<Item> {
        val itemsList = ArrayList<Item>()

        //using GSON example
        val json = """{"id": 684, "listId": "1", "name" : "Item 684"}"""
        //val json = JSONDownloader
        val gson = Gson()

        val item: Item = gson.fromJson(json, Item::class.java)
        itemsList.add(item)

        return itemsList
    }
}