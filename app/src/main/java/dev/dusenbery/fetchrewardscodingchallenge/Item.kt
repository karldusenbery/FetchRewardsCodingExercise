package dev.dusenbery.fetchrewardscodingchallenge

class Item(
    val id: Int,
    val listId: Int,
    val name: String
) {
    override fun toString(): String {
        return "Item [id: ${this.id.toString()}, listId: ${this.listId.toString()}, name: ${this.name}]"
    }
}