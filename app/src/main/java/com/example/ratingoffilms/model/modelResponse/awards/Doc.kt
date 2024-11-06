package com.example.ratingoffilms.model.modelResponse.awards

import androidx.annotation.Keep

@Keep
data class Doc(
    val createdAt: String?,
    val id: String?,
    val movie: Movie?,
    val nomination: Nomination?,
    val personId: Int?,
    val updatedAt: String?,
    val winning: Boolean?
)