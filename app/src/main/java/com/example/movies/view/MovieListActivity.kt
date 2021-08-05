package com.example.movies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.view.MovieListDetailsActivity
import com.example.movies.MoviesAdapter
import com.example.movies.databinding.ActivityMovieListBinding
import com.example.movies.model.MovieRepository

class MovieListActivity : AppCompatActivity() {
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
        val adapter = MoviesAdapter {id ->

            openDetailsActivity(id)
        }
        binding.moviesList.adapter = adapter

        MovieRepository.getPopular(1) {
            list ->
            adapter.addItemList(list)
       }
        MovieRepository.getPopular(2){list2 ->
            adapter.addItemList(list2)

        }

    }

   private fun openDetailsActivity(id: Int) {
      val intent = Intent(this, MovieListDetailsActivity::class.java)
       intent.putExtra("idMovie", id)

       startActivity(intent)
   }


}