package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.MoviesItemBinding
import com.example.movies.MoviesViewHolder as MoviesViewHolder1

class MoviesViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)

class MoviesAdapter(val movieClickListener: () -> Unit) : RecyclerView.Adapter<MoviesViewHolder1>() {


    val listMovies: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBinding.inflate(inflater, parent, false)
        return MoviesViewHolder1(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder1, position: Int) {

        val item = listMovies[position]
       //val item = listMovies.get(position)
        holder.binding.detailsId.text = item
        holder.binding.button.setOnClickListener{
            movieClickListener()
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun addItemList(list: List<String>){
        listMovies.addAll(list)
        notifyDataSetChanged()
    }


}