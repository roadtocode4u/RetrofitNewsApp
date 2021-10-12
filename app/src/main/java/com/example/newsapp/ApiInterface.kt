package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("news")
    fun getNews(@Query("access_key") access_key:String? = "74cfc131ba86195c8d51c025adf3b62e", @Query("countries") countries:String? = "in"):Call<News>

    companion object{
        var BASE_URL = "http://api.mediastack.com/v1/"

        fun create(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}