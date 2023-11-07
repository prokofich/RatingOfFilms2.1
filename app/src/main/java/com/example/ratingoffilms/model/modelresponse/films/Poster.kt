package com.example.ratingoffilms.model.modelresponse.films

import androidx.annotation.Keep

@Keep
data class Poster(
    val url: String?,
    val previewUrl: String?
)