package com.example.ratingoffilms.model.modelResponse.awards

import androidx.annotation.Keep

@Keep
data class Award(
    val title: String?,
    val year: Int?
)