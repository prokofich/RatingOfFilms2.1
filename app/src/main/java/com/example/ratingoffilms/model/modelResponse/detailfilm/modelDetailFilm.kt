package com.example.ratingoffilms.model.modelResponse.detailfilm

import androidx.annotation.Keep

@Keep
data class modelDetailFilm(
    val docs: List<Doc?>,
    val limit: Int?,
    val page: Int?,
    val pages: Int?,
    val total: Int?
)