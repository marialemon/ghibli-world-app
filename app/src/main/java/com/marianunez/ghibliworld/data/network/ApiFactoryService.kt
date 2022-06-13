package com.marianunez.ghibliworld.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactoryService {

    fun <T> createApi(apiClass: Class<T>): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASE_URL)
            .build()
            .create(apiClass)
    }
}