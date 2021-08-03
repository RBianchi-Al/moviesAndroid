package com.example.movies

import android.content.Intent
import com.example.movies.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movies.model.MovieRepository


class MovieListDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val idMovie = intent.getIntExtra("idMovie", -1)

        binding.buttonreturn.setOnClickListener {
            val mudaTela = Intent(this, MovieListActivity::class.java)
            startActivity(mudaTela)
        }
        MovieRepository.getMovie({

            binding.textsinopse.text = it.overview
            binding.titlemoviedescription.text = it.title
            binding.genero.text = it.genres.toString()
            binding.faixaetaria.text = if (it.adult) "+18" else "-18"
            binding.preferencia.text = it.vote_average.toString()
            binding.data.text = it.release_date
            binding.movieDuration.text = "${it.runtime} minute"
            binding.textcompany.text = "Company: ${it.production_companies}"

               Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${it.poster_path}")
                .into(binding.capa)

            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")
                .into(binding.poster)
        }, idMovie)





}


}