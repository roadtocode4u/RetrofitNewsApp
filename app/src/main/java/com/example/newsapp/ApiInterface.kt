package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("getNews.php")
    fun getNews(): Call<NewsArticle>

    companion object{
         var BASE_URL = "http://learn.roadtocode.org/"

        fun create(): ApiInterface{
            val retrofit  = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}