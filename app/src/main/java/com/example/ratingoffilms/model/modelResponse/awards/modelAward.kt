package com.example.ratingoffilms.model.modelResponse.awards

import androidx.annotation.Keep

@Keep
data class modelAward(
    val docs: List<Doc?>,
    val limit: Int?,
    val page: Int?,
    val pages: Int?,
    val total: Int?
)