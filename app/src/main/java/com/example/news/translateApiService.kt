package com.example.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleTranslateApiService {
    @GET("translate")
    suspend fun translate(
        @Query("q") query: String,
        @Query("target") target: String,
        @Query("key") apiKey: String
    ): TranslateResponse
}

data class TranslateResponse(
    val data: Data
)

data class Data(
    val translations: List<Translation>
)

data class Translation(
    val translatedText: String
)

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://translation.googleapis.com/language/translate/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val translateApiService: GoogleTranslateApiService = retrofit.create(GoogleTranslateApiService::class.java)
