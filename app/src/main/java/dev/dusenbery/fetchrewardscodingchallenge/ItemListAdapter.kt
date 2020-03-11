package dev.dusenbery.fetchrewardscodingchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(val items: ArrayList<Item>): RecyclerView.Adapter<ItemListViewHolder>() {

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

    }

}