package com.marianunez.ghibliworld.domain.model

import androidx.room.Entity

@Entity(tableName = "filmsList")
data class FilmsLocalEntity(
    val id: String = "",
    val title: String = "",
    val image: String = "",
    val movieBanner: String = "",
    val description: String = "",
    val director: String = "",
    val releaseDate: String = "",
    val rtScore: String = ""
)