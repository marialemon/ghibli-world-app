package com.marianunez.ghibliworld.data.repository

import com.marianunez.ghibliworld.data.network.response.FilmsResponse

interface FilmDetailRepository {

    suspend fun getFilmDetail(filmId: String): Result<FilmsResponse>
}