package dev.dusenbery.fetchrewardscodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var itemRecyclerView: RecyclerView
    val itemDataManager: ItemDataManager = ItemDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = itemDataManager.readItems()
        itemRecyclerView = findViewById(R.id.items_recyclerview)
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerView.adapter = ItemListAdapter(items)
    }
}
