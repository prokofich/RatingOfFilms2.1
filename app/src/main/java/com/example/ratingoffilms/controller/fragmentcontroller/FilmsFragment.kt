package com.example.ratingoffilms.controller.fragmentcontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ratingoffilms.R
import com.example.ratingoffilms.model.adapter.FilmsAdapter
import com.example.ratingoffilms.model.api.ApiServiceFilms
import com.example.ratingoffilms.model.api.InterfaceForFilmsFragment
import com.example.ratingoffilms.model.modelResponse.films.Doc

class FilmsFragment: Fragment(), InterfaceForFilmsFragment {

    private var recyclerView: RecyclerView? = null
    private var adapterFilms: FilmsAdapter? = null
    private var apiService: ApiServiceFilms? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiService = ApiServiceFilms(this)

        recyclerView = view.findViewById(R.id.id_rv_films)
        adapterFilms = FilmsAdapter()
        recyclerView?.adapter = adapterFilms

        /** загрузка фильмов */
        apiService?.loadFilms()
    }

    /** отправка в адаптер + показ фильмов */
    override fun setListForAdapter(list: List<Doc?>) {
        adapterFilms?.setList(list)
    }
}