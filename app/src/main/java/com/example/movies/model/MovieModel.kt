package com.example.movies.model

data class MovieModel(val title: String, val id: Int, val popularity: Double, val vote_count: Int, val poster_path: String, val original_language: String, val overview: String, val genres: List<GenreModel>?, val
production_companies: List<ProductionModel>?, val vote_average: Double, val adult: Boolean, val release_date: String, val backdrop_path: String, val runtime: Int?)
