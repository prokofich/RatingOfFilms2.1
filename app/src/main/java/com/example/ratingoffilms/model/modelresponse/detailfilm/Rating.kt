package com.example.ratingoffilms.model.modelresponse.detailfilm

import androidx.annotation.Keep

@Keep
data class Rating(
    val await: Any?,
    val filmCritics: Double?,
    val imdb: Double?,
    val kp: Double?,
    val russianFilmCritics: Int?
)