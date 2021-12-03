/**
 *  Here is a class to manage the parsing of Group objects
 */
package dev.dusenbery.fetchrewardscodingexercise

import android.content.Context

class GroupDataManager(private val context: Context) {

    var jsonString: String = """{"id": 000, "listId": 0, "name": "name"}"""

    // Returns an ArrayList of Groups based off of parsed Group objects
    fun readGroups(): ArrayList<Group> {

        // Initialize the ArrayList to be returned
        val groupsList = ArrayList<Group>()

        // Returns the ArrayList of Group objects
        return groupsList
    }
}