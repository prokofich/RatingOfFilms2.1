package com.example.ratingoffilms.model.modelresponse.awards

import androidx.annotation.Keep

@Keep
data class Movie(
    val id: Int?,
    val name: String?,
    val rating: Double?
)