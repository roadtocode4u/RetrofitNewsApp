package com.example.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val articlesList: List<Data>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentArticle = articlesList.get(position)

        holder.tvTitle.text = currentArticle.title
        Glide
            .with(holder.ivImage.context)
            .load(currentArticle.image)
            .into(holder.ivImage)

        holder.newsCard.setOnClickListener{
            val intent = Intent(holder.newsCard.context, DetailedNews::class.java)
            intent.putExtra("web_url", currentArticle.url)
            holder.newsCard.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

            val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
            val ivImage: ImageView = itemView.findViewById(R.id.iv_news)
            val newsCard: CardView = itemView.findViewById(R.id.newsCard)
    }
}


