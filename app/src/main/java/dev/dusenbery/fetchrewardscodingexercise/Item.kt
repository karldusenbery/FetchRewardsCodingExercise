/**
 *  Here is a model class to represent each JSON object as an object of this class
 */
package dev.dusenbery.fetchrewardscodingexercise

class Group(
    var id: Int,
    var name: String,
    var listId: Int
)

{
    /*Getters and Setters */
    fun getItemId(): Int {
        return id
    }

    fun setItemId(id: Int) {
        this.id = id
    }

    fun getItemName(): String? {
        return name
    }

    fun setItemName(name: String?) {
        this.name = name!!
    }

    fun getItemListId(): Int {
        return listId
    }

    fun setItemListId(listId: Int) {
        this.listId = listId
        /* end Getters and Setters */
    }

        override fun toString(): String {
            return "Item [id: ${this.id}, Name: ${this.name}, List ID: ${this.listId}]"
        }
}