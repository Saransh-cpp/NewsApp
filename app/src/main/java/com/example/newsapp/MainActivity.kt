package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

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

    private fun fetchData () {
        val url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=fd2c74c081f34ffca89e6af930c76bd2"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                {

                },
                {
                    Toast.makeText(this, "Oops! Something went wrong :(", Toast.LENGTH_LONG).show()

                })
        MySingleton.MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "Clicked $item", Toast.LENGTH_LONG).show()
    }
}