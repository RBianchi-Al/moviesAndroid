package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.databinding.ActivityMovieListBinding

class MovieList : AppCompatActivity() {
    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        setupList()
    }

    private fun initLayout(){
        this.binding = ActivityMovieListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    private fun setupList() {
        val adapter = MoviesAdapter {
            openDetailsActivity()
        }
        binding.moviesList.adapter = adapter
        val list:List<String> = List(10){
            "Film $it"
        }
        adapter.addItemList(list)
    }

   private fun openDetailsActivity() {
      val intent = Intent(this, MovieListDetails::class.java)
       startActivity(intent)
   }
}