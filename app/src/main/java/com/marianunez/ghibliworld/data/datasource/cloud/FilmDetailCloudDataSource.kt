package com.marianunez.ghibliworld.data.datasource.cloud

import com.marianunez.ghibliworld.data.network.ApiConstants
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.ApiRestService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import retrofit2.HttpException

class FilmDetailCloudDataSource(private val apiFactoryService: ApiFactoryService) {

    suspend fun getFilmDetail(filmId: String): Result<FilmsResponse> =
        try {
            val api = apiFactoryService.createApi(ApiRestService::class.java, ApiConstants.BASE_URL)
            val response = api.getFilmDetail(filmId)
            Result.success(response)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        } catch (e: IllegalArgumentException) {
            Result.failure(e)
        }
}

// los catch se ordenan de más específico a menos específico