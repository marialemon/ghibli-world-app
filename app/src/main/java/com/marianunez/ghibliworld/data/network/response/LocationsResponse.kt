package com.marianunez.ghibliworld.data.network.response

data class LocationsResponse(
    val id: String = "",
    val name: String = "",
    val climate: String = "",
    val terrain: String = "",
    val residents: List<PeopleResponse> = listOf(),
    val films: List<FilmsResponse> = listOf(),
)