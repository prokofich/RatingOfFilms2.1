package com.example.ratingoffilms.model.api

import com.example.ratingoffilms.model.modelresponse.films.Doc

interface InterfaceForFilmsFragment {
    fun setListForAdapter(list : List<Doc?>)
}