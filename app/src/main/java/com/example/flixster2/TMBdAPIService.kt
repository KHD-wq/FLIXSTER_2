package com.example.flixster2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbApi {
    @GET("person/popular")
    suspend fun getPopularActors(
        @Query("api_key") apiKey: String
    ): ActorResponse
}

object RetrofitInstance {
    val api: TMDbApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDbApi::class.java)
    }
}
