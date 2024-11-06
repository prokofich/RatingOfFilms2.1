package com.example.ratingoffilms.model.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ratingoffilms.R
import com.example.ratingoffilms.model.constant.MAIN
import com.example.ratingoffilms.model.modelResponse.films.Doc

class FilmsAdapter:RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var listFilms = listOf<Doc?>()

    class FilmsViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_films,parent,false)
        return FilmsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFilms.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {

        val nameFilm = holder.itemView.findViewById<TextView>(R.id.id_item_rv_films_tv_name_film)
        val ratingFilm = holder.itemView.findViewById<TextView>(R.id.id_item_rv_films_tv_rating)
        val imageFilm = holder.itemView.findViewById<ImageView>(R.id.id_item_rv_films_img)

        if (listFilms[position]?.name!=null &&
            listFilms[position]?.id!=null &&
            listFilms[position]?.rating?.kp!=null &&
            listFilms[position]?.poster?.url!=null ){

            nameFilm.text = listFilms[position]!!.name
            ratingFilm.text = "rating ${listFilms[position]!!.rating!!.kp}/10"
            imageFilm.load(listFilms[position]!!.poster!!.url)

        }

        holder.itemView.setOnClickListener {
            MAIN.setIdMovie(listFilms[position]!!.id!!)
            MAIN.showDetailFragment()
        }
    }



    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<Doc?>){
        listFilms = list
        notifyDataSetChanged()
    }

}