package com.example.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.news.databinding.ItemMovieBinding
import kotlinx.coroutines.*

class MovieAdapter(private val movies: List<Movie>, private val apiKey: String) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, apiKey: String) {
            binding.title.text = "${movie.title} (${movie.days_until} days)"
            Picasso.get().load(movie.poster_url).into(binding.poster)
            binding.releaseDate.text = movie.release_date

            CoroutineScope(Dispatchers.IO).launch {
                val translatedOverview = translateText(movie.overview, "fr", apiKey)
                withContext(Dispatchers.Main) {
                    binding.overview.text = translatedOverview
                }
            }
        }

        suspend fun translateText(text: String, targetLanguage: String, apiKey: String): String {
            val response = translateApiService.translate(text, targetLanguage, apiKey)
            return response.data.translations.firstOrNull()?.translatedText ?: text
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position], apiKey)
    }

    override fun getItemCount() = movies.size
}
