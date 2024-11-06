package com.example.ratingoffilms.controller.fragmentcontroller

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import coil.load
import com.example.ratingoffilms.R
import com.example.ratingoffilms.model.api.ApiServiceDetailFilm
import com.example.ratingoffilms.model.api.InterfaceForDetailFilmFragment
import com.example.ratingoffilms.model.constant.MAIN
import com.example.ratingoffilms.model.modelResponse.detailfilm.Doc

class DetailFilmsFragment: Fragment(), InterfaceForDetailFilmFragment {

    private var apiService: ApiServiceDetailFilm? = null
    private var img: ImageView? = null
    private var nameFilm: TextView? = null
    private var ageRating: TextView? = null
    private var rating: TextView? = null
    private var ratingCritics: TextView? = null
    private var durationFilm: TextView? = null
    private var yearFilm: TextView? = null
    private var description: TextView? = null
    private var buttonBack: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img = view.findViewById(R.id.id_fragment_details_img)
        nameFilm = view.findViewById(R.id.id_fragment_details_tv_name_film)
        ageRating = view.findViewById(R.id.id_fragment_details_tv_age_limit)
        rating = view.findViewById(R.id.id_fragment_details_tv_rating_kp)
        ratingCritics = view.findViewById(R.id.id_fragment_details_tv_rating_kritics)
        durationFilm = view.findViewById(R.id.id_fragment_details_tv_duration)
        yearFilm = view.findViewById(R.id.id_fragment_details_tv_year)
        description = view.findViewById(R.id.id_fragment_details_tv_desc)
        buttonBack = view.findViewById(R.id.id_fragment_details_button_back)

        apiService = ApiServiceDetailFilm(this)
        apiService?.loadFilm(MAIN.getIdMovie().toString())

        /** возврат на начальные экраны */
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().supportFragmentManager.beginTransaction().remove(this@DetailFilmsFragment).commit()
        }

        /** возврат на начальные экраны */
        buttonBack?.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this@DetailFilmsFragment).commit()
        }

    }

    /** показ всех параметров */
    @SuppressLint("SetTextI18n")
    override fun sendParameters(list : List<Doc?>) {
        img?.load(list[0]?.backdrop?.url)
        nameFilm?.text = list[0]?.name
        ageRating?.text = "${list[0]?.ageRating}+"
        rating?.text = "viewer rating: ${list[0]?.rating?.kp}/10"
        ratingCritics?.text = "critics rating: ${list[0]?.rating?.filmCritics}/10"
        durationFilm?.text = "duration: ${list[0]?.movieLength} min"
        yearFilm?.text = "released: ${list[0]?.year} year"
        description?.text = list[0]?.description
    }

}