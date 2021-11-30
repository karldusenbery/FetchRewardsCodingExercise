/**
 *  Here is the View Holder for the items_recyclerview in the content_main.xml layout
 *  It is connected to the ItemListAdapter
 */

package dev.dusenbery.fetchrewardscodingexercise

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fetchrewardscodingexercise.R

class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var itemIdTextView = itemView.findViewById<TextView>(R.id.itemIdNumber)
    var itemNameTextView = itemView.findViewById<TextView>(R.id.itemName)
    var itemListIdTextView = itemView.findViewById<TextView>(R.id.itemListId)
}