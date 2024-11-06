package com.example.ratingoffilms.model.modelResponse.films

import androidx.annotation.Keep

@Keep
data class Rating(
    val kp: Double?,
    val imdb: Double?,
    val filmCritics: Double?,
    val russianFilmCritics: Double?,
    val await:String?
)