package com.marianunez.ghibliworld.data.repository

import com.marianunez.ghibliworld.data.network.response.FilmsResponse

interface FilmsListRepository {

    suspend fun getFilmsList(): Result<List<FilmsResponse>>
}