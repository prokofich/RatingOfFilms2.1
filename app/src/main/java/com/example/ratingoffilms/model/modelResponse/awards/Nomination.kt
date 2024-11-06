package com.example.ratingoffilms.model.modelResponse.awards

import androidx.annotation.Keep

@Keep
data class Nomination(
    val award: Award?,
    val title: String?
)