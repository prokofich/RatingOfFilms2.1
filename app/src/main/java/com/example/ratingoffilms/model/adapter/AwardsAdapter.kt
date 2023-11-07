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
import com.example.ratingoffilms.model.modelresponse.awards.Doc

class AwardsAdapter:RecyclerView.Adapter<AwardsAdapter.AwardsViewHolder>() {

    private var listAwards = listOf<Doc?>()

    class AwardsViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_awards,parent,false)
        return AwardsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAwards.size
    }

    override fun onBindViewHolder(holder: AwardsViewHolder, position: Int) {

        val nameFilm = holder.itemView.findViewById<TextView>(R.id.id_item_rv_awards_tv_name_film)
        val nameTitleAward = holder.itemView.findViewById<TextView>(R.id.id_item_rv_awards_tv_name_awards)
        val imageAward = holder.itemView.findViewById<ImageView>(R.id.id_item_rv_awards_img)

        if( listAwards[position]?.movie?.name!=null &&
            listAwards[position]?.nomination?.title!=null &&
            listAwards[position]?.nomination?.award?.title == "Оскар"){

            nameFilm.text = listAwards[position]!!.movie!!.name
            nameTitleAward.text = listAwards[position]!!.nomination!!.title
            imageAward.load(R.drawable.oscar)

        }

        holder.itemView.setOnClickListener {
            MAIN.setIdMovie(listAwards[position]!!.movie!!.id!!)
            MAIN.showDetailFragment()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<Doc?>){
        listAwards = list
        notifyDataSetChanged()
    }

}