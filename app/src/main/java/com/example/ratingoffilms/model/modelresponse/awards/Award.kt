package com.example.ratingoffilms.model.modelresponse.awards

import androidx.annotation.Keep

@Keep
data class Award(
    val title: String?,
    val year: Int?
)