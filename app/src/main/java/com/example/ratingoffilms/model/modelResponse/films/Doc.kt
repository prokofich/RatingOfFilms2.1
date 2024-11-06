package com.example.ratingoffilms.model.modelResponse.films

import androidx.annotation.Keep

@Keep
data class Doc(
    val id: Int?,
    val name: String?,
    val poster: Poster?,
    val rating: Rating?
)