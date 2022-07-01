package com.marianunez.ghibliworld.fakedata

import com.marianunez.ghibliworld.data.network.response.FilmsResponse

val fakeFilmsResponse = FilmsResponse(
    id = "",
    title = "",
    image = "",
    movieBanner = "",
    description = "",
    director = "",
    releaseDate = "",
    rtScore = "",
    people = listOf(),
    species = listOf(),
    locations = listOf(),
    vehicles = listOf(),
)

val fakeFilmsListResponse = Result.success(
    listOf(
        fakeFilmsResponse,
        fakeFilmsResponse,
        fakeFilmsResponse,
        fakeFilmsResponse
    )
)