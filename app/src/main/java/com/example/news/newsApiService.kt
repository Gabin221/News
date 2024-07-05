package com.example.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("latest")
    suspend fun getLatestNews(
        @Query("apikey") apiKey: String,
        @Query("q") query: String,
        @Query("language") language: String
    ): NewsResponse
}

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val results: List<ArticleNewsResult>
)

data class ArticleNewsResult(
    val title: String,
    val link: String,
    val category: List<String>,
    val image_url: String,
    val description: String,
    val pubDate: String,
    val creator: List<String>
)

object NewsRetrofitInstance {
    val api: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsdata.io/api/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}