package com.marianunez.ghibliworld.data.datasource.cloud

import com.marianunez.ghibliworld.data.network.ApiConstants
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.network.ApiRestService
import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import retrofit2.HttpException
import java.util.Date

class FilmsListCloudDataSource(private val apiFactoryService: ApiFactoryService, private val baseUrl: String = ApiConstants.BASE_URL) {

    private var timeStamp: String = Date().time.toString()

    suspend fun getFilmsList(): Result<List<FilmsResponse>> =
        try {
            val api = apiFactoryService.createApi(ApiRestService::class.java, baseUrl)
            val response = api.getFilms(10, timeStamp, "name")
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