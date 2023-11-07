package com.example.ratingoffilms.model.modelresponse.awards

import androidx.annotation.Keep

@Keep
data class modelAward(
    val docs: List<Doc?>,
    val limit: Int?,
    val page: Int?,
    val pages: Int?,
    val total: Int?
)