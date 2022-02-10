package com.reihan.androidpemula.Kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reihan.androidpemula.DetailActivity
import com.reihan.androidpemula.databinding.ItemNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(private val itemNews: ItemNewsBinding) :
        RecyclerView.ViewHolder(itemNews.root) {
        fun bindItem(news: News) {
            itemNews.tvTitle.text = news.title
            itemNews.tvAuthor.text = news.author
            itemNews.tvDate.text = news.date
            itemNews.imgNews.setImageResource(news.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(listNews[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.NEWS_TITLE, listNews[position].title)
            intent.putExtra(DetailActivity.NEWS_AUTHOR, listNews[position].author)
            intent.putExtra(DetailActivity.NEWS_DATE, listNews[position].date)
            intent.putExtra(DetailActivity.NEWS_DESC, listNews[position].desc)
            intent.putExtra(DetailActivity.NEWS_IMAGE, listNews[position].photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listNews.size
}
