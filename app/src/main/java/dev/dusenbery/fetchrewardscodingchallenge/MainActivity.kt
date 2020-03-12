package dev.dusenbery.fetchrewardscodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var itemRecyclerView: RecyclerView
    val itemDataManager: ItemDataManager = ItemDataManager(this)
    private var jsonURL = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = itemDataManager.readItems()
        itemRecyclerView = findViewById(R.id.items_recyclerview)
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerView.adapter = ItemListAdapter(items)

        JSONDownloader(this@MainActivity, jsonURL).execute()
    }
}
