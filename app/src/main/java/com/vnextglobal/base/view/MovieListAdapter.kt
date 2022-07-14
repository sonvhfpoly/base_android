package com.vnextglobal.base.view

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vnextglobal.aframework.xml.BaseBindingHolder
import com.vnextglobal.aframework.xml.getLayoutInflater
import com.vnextglobal.base.databinding.HolderMovieBinding
import com.vnextglobal.core.model.Movie

class MovieListAdapter : PagingDataAdapter<Movie, RecyclerView.ViewHolder>(UI_COMPARATOR){

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            (holder as MovieHolder).bind(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieHolder(parent)
    }

    companion object{
        private val UI_COMPARATOR = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}

class MovieHolder(container: ViewGroup) : BaseBindingHolder<HolderMovieBinding>(HolderMovieBinding.inflate(container.getLayoutInflater(), container, false)){

    fun bind(movie: Movie){
        binding.movieName.text = movie.title
        binding.movieOverview.text = movie.overview
        binding.moviePoster.load(movie.getPosterUrlPath())
    }
}