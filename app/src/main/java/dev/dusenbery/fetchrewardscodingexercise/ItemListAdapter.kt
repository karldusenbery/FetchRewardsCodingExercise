/**
 *  Here is the adapter for the items_recyclerview in the content_main.xml layout
 *  It uses the ItemListViewHolder to display data in each row
 */

package dev.dusenbery.fetchrewardscodingexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fetchrewardscodingexercise.R

class ItemListAdapter(private var c: Context?, val items: ArrayList<Group>): RecyclerView.Adapter<ItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_view_holder, parent, false)
        return ItemListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.itemIdTextView.text = items[position].id.toString()
        holder.itemNameTextView.text = items[position].name
        holder.itemListIdTextView.text = items[position].listId.toString()
    }
}