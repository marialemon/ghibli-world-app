package com.marianunez.ghibliworld.data.network.response

data class SpeciesResponse(
    val id: String = "",
    val name: String = "",
    val classification: String = "",
    val people: List<PeopleResponse> = listOf(),
    val films: List<FilmsResponse> = listOf(),
)
