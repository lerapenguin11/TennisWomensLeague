package com.example.tenniswomensleague.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.business.models.NewsModel

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    val newsList = mutableListOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)

        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news : NewsModel = newsList[position]

        holder.title.text = news.title
        Glide.with(holder.itemView)
            .load(news.photo)
            //.override(200, 109)
            .into(holder.photo)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(list : List<NewsModel>){
        this.newsList.clear()
        this.newsList.addAll(list)
        notifyDataSetChanged()
    }

    class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val photo : ImageView = view.findViewById(R.id.new_photo)
        val title : TextView = view.findViewById(R.id.tv_title)
    }

}