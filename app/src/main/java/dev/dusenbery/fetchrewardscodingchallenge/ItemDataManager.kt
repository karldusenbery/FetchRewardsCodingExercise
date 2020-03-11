package dev.dusenbery.fetchrewardscodingchallenge

import android.content.Context
import kotlinx.android.synthetic.main.item_list_view_holder.view.*
import org.json.JSONArray

class ItemDataManager(private val context: Context) {

    fun readItems(): ArrayList<Item> {
        val itemsList = ArrayList<Item>()

        //dummy items
        val item = Item(1, 123, "ONE")
        val item2 = Item(2, 456, "TWO")



        //add the dummy items
        itemsList.add(item)
        itemsList.add(item2)

        return itemsList
    }
}