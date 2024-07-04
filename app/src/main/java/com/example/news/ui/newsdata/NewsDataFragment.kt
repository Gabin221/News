package com.example.news.ui.newsdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.news.databinding.FragmentNewsdataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.ArticleNews
import com.example.news.ArticlesNewsAdapter
import com.example.news.R

class NewsDataFragment : Fragment() {

    private var _binding: FragmentNewsdataBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private val articlesNews = mutableListOf<ArticleNews>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsdataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = root.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ArticlesNewsAdapter(articlesNews)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}