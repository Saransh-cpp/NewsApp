package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val item = fetchData()
        var adapter: NewsListAdapter = NewsListAdapter(item, this)
        recyclerView.adapter = adapter
    }

    private fun fetchData (): ArrayList<String> {
        val list  = ArrayList<String>()
        for (i in 0 until 100) {
            list.add("Item $i")
        }

        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "Clicked $item", Toast.LENGTH_LONG).show()
    }
}