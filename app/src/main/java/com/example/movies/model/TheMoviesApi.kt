package com.example.movies.model


import android.net.wifi.rtt.CivicLocationKeys.LANGUAGE
import com.example.movies.model.ApiConsts.API_KEY
import com.example.movies.model.ApiConsts.IDIOM
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMoviesApi {

    @GET("popular")
    fun listPopular(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") idiom: String = IDIOM,
        @Query("page") page: Int): Call<MovieList>


    @GET("{idMovie}")
    fun getMovieById(
        @Path("idMovie") id: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") idiom: String = IDIOM
    ): Call<MovieModel>

    @GET("3/search/movie")
    fun searchMovie(@Query("api_key") apiKey: String = API_KEY,
                    @Query("query") searchqueryapi: String,
                    @Query("language") idioma:String = IDIOM
    ): Call<MovieList>

    @GET("top_rated")
    fun listTopRated(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") idiom: String = IDIOM,
        @Query("page") page: Int
    ): Call<MovieList>

    @GET("upcoming")
    fun listUpcoming(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") idiom: String = IDIOM,
        @Query("page") page: Int
    ): Call<MovieList>

    @GET("latest")
    fun listFavorite(@Query("api_key") apiKey: String = API_KEY,
                     @Query("language") idiom: String = IDIOM,
                     @Query("page") page: Int): Call<MovieList>




}