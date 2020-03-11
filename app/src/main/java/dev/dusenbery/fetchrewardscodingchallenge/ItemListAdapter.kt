package dev.dusenbery.fetchrewardscodingchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(val lists: ArrayList<ItemList>): RecyclerView.Adapter<ItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_view_holder, parent, false)
        return ItemListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {

        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = lists[position].name

    }

    fun addList(list: ItemList) {
        lists.add(list)
        notifyItemInserted(lists.size-1)
    }

}