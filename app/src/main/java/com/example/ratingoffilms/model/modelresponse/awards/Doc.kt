package com.example.ratingoffilms.model.modelresponse.awards

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