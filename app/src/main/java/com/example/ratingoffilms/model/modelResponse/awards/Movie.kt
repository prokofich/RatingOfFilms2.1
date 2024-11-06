package com.example.ratingoffilms.model.modelResponse.awards

import androidx.annotation.Keep

@Keep
data class Movie(
    val id: Int?,
    val name: String?,
    val rating: Double?
)