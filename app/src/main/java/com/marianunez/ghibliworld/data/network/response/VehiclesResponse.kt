package com.marianunez.ghibliworld.data.network.response

data class VehiclesResponse(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val films: List<FilmsResponse> = listOf(),
)
