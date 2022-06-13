package com.marianunez.ghibliworld.data.datasource.cloud

import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.ApiRestService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import java.util.Date

class FilmsListCloudDataSource(private val apiFactoryService: ApiFactoryService) {

    private var timeStamp: String = Date().time.toString()

    suspend fun getFilmsList(): List<FilmsResponse> {
        val api = apiFactoryService.createApi(ApiRestService::class.java)
        return api.getFilms(10, timeStamp, "name")
    }
}