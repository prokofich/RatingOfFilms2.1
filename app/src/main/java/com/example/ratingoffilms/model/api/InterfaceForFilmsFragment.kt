package com.example.ratingoffilms.model.api

import com.example.ratingoffilms.model.modelResponse.films.Doc

interface InterfaceForFilmsFragment {
    fun setListForAdapter(list: List<Doc?>)
}