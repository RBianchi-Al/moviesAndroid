package com.example.movies.model

data class ProductionMovies(val name: String, val logo_path: String, val origin_country: String){
    override fun toString(): String {
        return name
    }


}
