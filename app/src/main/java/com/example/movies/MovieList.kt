package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.databinding.ActivityMovieListBinding

class MovieList : AppCompatActivity() {
    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_movie_list)

        initLayout()

        setupList()
    }
    private fun initLayout(){
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    private fun setupList() {
        val adapter = MoviesAdapter()
        binding.moviesList.setAdapter(adapter)
        val list:List<String> = List(10){
            "O gambito da Rainha ${it}"
        }
        adapter.addItemList(list)
    }

    private fun openDetailsActivity() {
        val intent = Intent(this, MovieListDetails::class.java)
        startActivity(intent)
    }
}