package com.marianunez.ghibliworld.domain.model.mapper

import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import com.marianunez.ghibliworld.domain.model.FilmsLocalEntity
import com.marianunez.ghibliworld.domain.model.FilmsModel

fun FilmsResponse.toModel(): FilmsModel {
    return FilmsModel(
        id = id,
        title = title,
        image = image,
        movieBanner = movieBanner,
        description = description,
        director = director,
        releaseDate = releaseDate,
        rtScore = rtScore
    )
}

fun FilmsResponse.toLocalEntity(): FilmsLocalEntity {
    return FilmsLocalEntity(
        id = id,
        title = title,
        image = image,
        movieBanner = movieBanner,
        description = description,
        director = director,
        releaseDate = releaseDate,
        rtScore = rtScore
    )
}