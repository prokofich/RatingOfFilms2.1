package com.example.ratingoffilms.model.api

import com.example.ratingoffilms.model.modelresponse.detailfilm.Doc

interface InterfaceForDetailFilmFragment {
    fun sendParameters(list: List<Doc?>)
}