package com.marianunez.ghibliworld.data.network.response

data class PeopleResponse(
    val id: String = "",
    val name: String = "",
    val gender: String = "",
    val age: String = "",
    val films: List<FilmsResponse> = listOf(),
    val species: SpeciesResponse = SpeciesResponse(),
)
