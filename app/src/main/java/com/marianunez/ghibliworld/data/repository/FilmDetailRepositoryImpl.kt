package com.marianunez.ghibliworld.data.repository

import com.marianunez.ghibliworld.data.datasource.cloud.FilmDetailCloudDataSource
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse

class FilmDetailRepositoryImpl(
    private val filmDetailCloudDataSource: FilmDetailCloudDataSource = FilmDetailCloudDataSource(
        ApiFactoryService()
    )
) : FilmDetailRepository {

    override suspend fun getFilmDetail(filmId: String): Result<FilmsResponse> {
        return filmDetailCloudDataSource.getFilmDetail(filmId)
    }
}