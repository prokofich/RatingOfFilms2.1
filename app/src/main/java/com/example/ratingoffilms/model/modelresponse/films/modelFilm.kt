package com.example.ratingoffilms.model.modelresponse.films

import androidx.annotation.Keep


@Keep
data class modelFilm(
    val docs: List<Doc?>,
    val limit: Int?,
    val page: Int?,
    val pages: Int?,
    val total: Int?
)