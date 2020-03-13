package dev.dusenbery.fetchrewardscodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Initialize RecyclerView.
    private lateinit var itemRecyclerView: RecyclerView

    // Initialize ItemDataManager class
    val itemDataManager: ItemDataManager = ItemDataManager(this)

    // URL to get JSON
    private var jsonURL = "https://fetch-hiring.s3.amazonaws.com/hiring.json"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Execute the function that will return the ArrayList of Items that will populate the RecyclerView
        val items = itemDataManager.readItems()

        // Connect the items_recyclerview RecyclerView layout in the content_main.xml layout to the var itemRecyclerView
        itemRecyclerView = findViewById(R.id.items_recyclerview)

        // Make the recycler view work with a LinearLayout
        itemRecyclerView.layoutManager = LinearLayoutManager(this)

        // put the ArrayList returned from itemDataManager.readItems() in the RecyclerView's adapter
        itemRecyclerView.adapter = ItemListAdapter(items)

        // Pass the Json URL to the JSONDownloader class that does the work of downloading the Json from that URL
        //JSONDownloader(this@MainActivity, jsonURL).execute()

    }
}
