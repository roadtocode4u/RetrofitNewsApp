package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val call = ApiInterface.create().getNews()
        call.enqueue(object: Callback<NewsArticle>{
            override fun onResponse(call: Call<NewsArticle>, response: Response<NewsArticle>) {

                val adapter = response.body()?.articles?.let {
                    CustomAdapter(it)
                }

                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<NewsArticle>, t: Throwable) {
                    Log.d("STATUS", "ERROR")
            }

        })




    }
}