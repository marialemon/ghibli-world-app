package com.marianunez.ghibliworld.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactoryService {

    fun <T> createApi(apiClass: Class<T>): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASE_URL)
            .build() // crea la clase retrofit
            .create(apiClass) // esto crea la implementación de la interfaz que se le pasa
    }
}