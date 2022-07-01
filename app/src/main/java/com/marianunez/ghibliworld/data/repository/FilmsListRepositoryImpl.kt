package com.marianunez.ghibliworld.data.repository

import com.marianunez.ghibliworld.data.datasource.cloud.FilmsListCloudDataSource
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse

class FilmsListRepositoryImpl(
    private val filmsListCloudDataSource: FilmsListCloudDataSource = FilmsListCloudDataSource(ApiFactoryService())
) :
    FilmsListRepository {

    /* private val filmsListCloudDataSource =
          FilmsListCloudDataSource(apiFactoryService = ApiFactoryService()) */

    override suspend fun getFilmsList(): Result<List<FilmsResponse>> {
        return filmsListCloudDataSource.getFilmsList()
    }
}