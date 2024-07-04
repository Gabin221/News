package com.example.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.news.databinding.ItemArticleNewsBinding

class ArticlesNewsAdapter(private val articleNews: List<ArticleNews>) : RecyclerView.Adapter<ArticlesNewsAdapter.ArticleNewsViewHolder>() {

    class ArticleNewsViewHolder(private val binding: ItemArticleNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(articleNews: ArticleNews) {
            binding.title.text = articleNews.title
            binding.link.text = articleNews.link
            binding.category.text = articleNews.category
            Picasso.get().load(articleNews.poster).into(binding.poster)
            binding.description.text = articleNews.description
            binding.date.text = articleNews.date
            binding.auteur.text = articleNews.auteur
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleNewsViewHolder {
        val binding = ItemArticleNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleNewsViewHolder, position: Int) {
        holder.bind(articleNews[position])
    }

    override fun getItemCount() = articleNews.size
}
