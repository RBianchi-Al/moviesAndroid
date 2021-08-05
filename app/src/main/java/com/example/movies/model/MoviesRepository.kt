package com.example.movies.model
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .build()

    val moviesApi: TheMoviesApi = retrofit.create(TheMoviesApi::class.java)

    fun getPopular(page: Int, callback: (List<MovieModel>) -> Unit){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main){
            withContext(Dispatchers.IO){
                val callApi = moviesApi.listPopular(page = page)
                callApi.enqueue(object : Callback<MovieList>{
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {

                    }
                })
            }
        }
    }
    fun getMovie(callback: (MovieModel) -> Unit, id: Int){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main){
            withContext(Dispatchers.IO){
                val callApi = moviesApi.getMovieById(id)
                callApi.enqueue(object : Callback<MovieModel>{
                    override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                        response.body()?.let {movie ->
                            callback(movie)
                        }

                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {

                    }
                })
            }
        }
    }

    fun getTopRated(page: Int, callback: (List<MovieModel>) -> Unit){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val callApi = moviesApi.listTopRated(page = page)
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        println("Caiu no onFailure")
                    }
                })
            }
        }
    }

    fun getUpcoming(page: Int, callback: (List<MovieModel>) -> Unit){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val callApi = moviesApi.listUpcoming(page = page)
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        println("Caiu no onFailure")
                    }
                })
            }
        }
    }

    fun getFavorite(page: Int, callback: (List<MovieModel>) -> Unit){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val callApi = moviesApi.listFavorite(page = page)
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        println("Caiu no onFailure")
                    }
                })
            }
        }
    }

}
