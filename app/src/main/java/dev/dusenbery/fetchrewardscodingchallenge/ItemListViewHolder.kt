package dev.dusenbery.fetchrewardscodingchallenge

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var itemIdTextView = itemView.findViewById<TextView>(R.id.itemIdNumber)
    var itemNameTextView = itemView.findViewById<TextView>(R.id.itemName)
}