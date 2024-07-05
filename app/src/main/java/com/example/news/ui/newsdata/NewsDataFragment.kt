package com.example.news.ui.newsdata

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.ArticleNews
import com.example.news.ArticlesNewsAdapter
import com.example.news.databinding.FragmentNewsdataBinding
import com.example.news.NewsRetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsDataFragment : Fragment() {

    private var _binding: FragmentNewsdataBinding? = null
    private val binding get() = _binding!!
    private val articlesNews = mutableListOf<ArticleNews>()
    private lateinit var adapter: ArticlesNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsdataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        fetchNews()

        return root
    }

    private fun setupRecyclerView() {
        adapter = ArticlesNewsAdapter(articlesNews)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun fetchNews() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = NewsRetrofitInstance.api.getLatestNews(
                    apiKey = "YOUR_API_KEY",
                    query = "pizza",
                    language = "fr"
                )

                if (response.status == "success") {
                    val fetchedArticles = response.results.map {
                        ArticleNews(
                            title = it.title,
                            link = it.link,
                            category = it.category.joinToString(", "),
                            poster = it.image_url,
                            description = it.description,
                            date = it.pubDate,
                            auteurs = it.creator.joinToString(", ")
                        )
                    }

                    withContext(Dispatchers.Main) {
                        articlesNews.addAll(fetchedArticles)
                        adapter.notifyDataSetChanged()
                        // Log the fetched articles
                        Log.d("NewsDataFragment", "Fetched articles: $fetchedArticles")
                    }
                } else {
                    Log.e("NewsDataFragment", "Failed to fetch news: ${response.status}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("NewsDataFragment", "Error fetching news", e)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
