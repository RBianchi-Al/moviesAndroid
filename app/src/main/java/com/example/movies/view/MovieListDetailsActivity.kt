package com.example.movies.view

import android.content.Intent
import com.example.movies.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movies.model.MovieModel
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
            binding.genero.text = getFormattedGenreList(it)
            binding.movieAdult.text = if (it.adult) "Adult" else "Family"
            binding.preferencia.text = it.vote_average.toString()
            binding.data.text = it.release_date
            binding.movieDuration.text = "${it.runtime} minute"
            binding.popularidadeMovie.text = it.popularity.toString()
            binding.voteCont.text = it.vote_count.toString()
            binding.language.text = it.original_language



            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${it.poster_path}")
                .into(binding.capaMovie)

            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")
                .into(binding.poster)
        }, idMovie)


    }


    private fun getFormattedGenreList(movie: MovieModel): String{
        var textGenrer = ""
        movie.genres?.forEachIndexed{index, genrer ->
            if(index == 0) {
                textGenrer+= genrer
            }else{
                textGenrer+= ", $genrer"
            }

        }
        return textGenrer
    }


    private fun getFormattedCompanyList(movie: MovieModel): String{
        var textCompany = ""
        movie.production_companies?.forEachIndexed{index, company ->

            if(index == 0) {
                textCompany+= "$company "
            }else{
                textCompany+= ", $company"
            }

        }
        return textCompany
    }
}