package com.example.ratingoffilms.controller.fragmentcontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ratingoffilms.R
import com.example.ratingoffilms.model.adapter.AwardsAdapter
import com.example.ratingoffilms.model.adapter.FilmsAdapter
import com.example.ratingoffilms.model.api.ApiServiceAwards
import com.example.ratingoffilms.model.api.ApiServiceFilms
import com.example.ratingoffilms.model.api.InterfaceForAwardsFragment
import com.example.ratingoffilms.model.modelresponse.awards.Doc

class AwardsFragment : Fragment(),InterfaceForAwardsFragment {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterAwards: AwardsAdapter
    private lateinit var apiService:ApiServiceAwards

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_awards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiService = ApiServiceAwards(this)

        recyclerView = view.findViewById(R.id.id_rv_awards)
        adapterAwards = AwardsAdapter()
        recyclerView.adapter = adapterAwards

        //загрузка наград фильмов
        apiService.loadAwards()

    }

    //отправка в адаптер + показ наград фильмов
    override fun setListForAdapter(list: List<Doc?>) {
        adapterAwards.setList(list)
    }

}