/**
 *  Here is the View Holder for the groups_recyclerview in the content_main.xml layout
 *  It is connected to the GroupListAdapter
 */

package dev.dusenbery.fetchrewardscodingexercise

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fetchrewardscodingexercise.R

class GroupListViewHolder(groupView: View) : RecyclerView.ViewHolder(groupView) {

    var groupTextTextView = groupView.findViewById<TextView>(R.id.groupText)
    var groupNumberTextView = groupView.findViewById<TextView>(R.id.groupNumber)
}