package com.example.ratingoffilms.model.modelResponse.detailfilm

import androidx.annotation.Keep

@Keep
data class Doc(
    val ageRating: Int?,
    val backdrop: Backdrop?,
    val description: String?,
    val movieLength: Int?,
    val name: String?,
    val rating: Rating?,
    val year: Int?
)