package com.meisam.imdbmovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meisam.imdbmovie.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movie: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMG_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie) {
            itemView.tvMovieName.text = movie.title
            itemView.tvMovieDateRelease.text = movie.release
            itemView.tvRate.text = movie.popularity
            itemView.tvLang.text = movie.lang
            Glide.with(itemView).load(IMG_BASE + movie.poster).into(itemView.ImgMovie)



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movie.get(position))
    }

    override fun getItemCount(): Int = movie.size


}