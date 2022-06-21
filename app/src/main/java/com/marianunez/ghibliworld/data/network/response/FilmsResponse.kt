package com.marianunez.ghibliworld.data.network.response

import com.google.gson.annotations.SerializedName

data class FilmsResponse(
    val id: String = "",
    val title: String = "",
    val image: String = "",
    @SerializedName("movie_banner")
    val movieBanner: String = "",
    val description: String = "",
    val director: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("rt_score")
    val rtScore: String = "",
    val people: List<String> = listOf(),
    val species: List<String> = listOf(),
    val locations: List<String> = listOf(),
    val vehicles: List<String> = listOf(),
)

/** ponemos un valor por defecto aunque sea una string vacía
 * porque si en un futuro la API cambia algún campo y no hemos inicializado ese valor aquí, petaría
 */


