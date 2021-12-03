/**
 *  Here is the adapter for the groups_recyclerview in the content_main.xml layout
 *  It uses the GroupListViewHolder to display data in each row
 */

package dev.dusenbery.fetchrewardscodingexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fetchrewardscodingexercise.R

class GroupListAdapter(private var c: Context?, val groups: ArrayList<Group>): RecyclerView.Adapter<GroupListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.group_list_view_holder, parent, false)
        return GroupListViewHolder(view)
    }
    /*
    override fun getGroupCount(): Int {
        return groups.size
    }*/

    override fun onBindViewHolder(holder: GroupListViewHolder, position: Int) {
        //holder.groupNumberTextView.text = groups[position].number.toString()
    }
}