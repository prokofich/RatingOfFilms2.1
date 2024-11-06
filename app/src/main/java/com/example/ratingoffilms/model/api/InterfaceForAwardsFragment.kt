package com.example.ratingoffilms.model.api

import com.example.ratingoffilms.model.modelResponse.awards.Doc

interface InterfaceForAwardsFragment {
    fun setListForAdapter(list: List<Doc?>)
}