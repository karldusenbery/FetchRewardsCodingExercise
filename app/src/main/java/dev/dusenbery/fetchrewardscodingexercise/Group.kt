/**
 *  Here is a model class to represent each listId grouped as an object of this class
 */
package dev.dusenbery.fetchrewardscodingexercise

class Group(
    var number: Int
)

{
    /*Getters and Setters */
    fun getGroupNumber(): Int {
        return number
    }

    fun setGroupNumber(id: Int) {
        this.number = number
    }

        override fun toString(): String {
            return "Group [number: ${this.number}]"
        }
}