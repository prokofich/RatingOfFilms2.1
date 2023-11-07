package com.example.ratingoffilms.model.modelresponse.awards

import androidx.annotation.Keep

@Keep
data class Nomination(
    val award: Award?,
    val title: String?
)