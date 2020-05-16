package com.example.appcorona

import android.media.ThumbnailUtils

data class UiModel(
    val thumbnailUrl : String,
    val name: String,
    val cases: Long,
    val deaths: Long,
    val recoveries: Long,
    val onClick: () -> Unit
)