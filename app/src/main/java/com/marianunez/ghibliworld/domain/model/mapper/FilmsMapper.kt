package com.marianunez.ghibliworld.domain.model.mapper

import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import com.marianunez.ghibliworld.domain.model.FilmsModel

fun FilmsResponse.toModel(): FilmsModel {
    return FilmsModel(id, title, image, movieBanner, description, director, releaseDate, rtScore)
}