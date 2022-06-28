package com.marianunez.ghibliworld.data.datasource.cloud

import com.marianunez.ghibliworld.data.network.ApiConstants
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.ApiRestService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse

class FilmDetailCloudDataSource(private val apiFactoryService: ApiFactoryService) {

    suspend fun getFilmDetail(filmId: String): FilmsResponse {
        val api = apiFactoryService.createApi(ApiRestService::class.java, ApiConstants.BASE_URL)
        return api.getFilmDetail(filmId)
    }
}