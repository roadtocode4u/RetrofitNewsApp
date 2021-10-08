package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val articlesList: List<Article>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentArticle = articlesList.get(position)
        holder.tvTitle.text = currentArticle.title
        Glide
            .with(holder.ivImage.context)
            .load(currentArticle.urlToImage)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
            val ivImage: ImageView = itemView.findViewById(R.id.iv_news)
    }
}


