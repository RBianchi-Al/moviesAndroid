package com.example.movies.model


import com.example.movies.model.ApiConsts.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi {
    @GET("3/movie/popular?api_key=$API_KEY&language=en-US&page=1")
    fun listPopular(): Call<MovieList>

    @GET("3/movie/{idMovie}?api_key=$API_KEY&language=en-US")
    fun getMovieById(@Path("idMovie")id: Int): Call<MovieModel>
}