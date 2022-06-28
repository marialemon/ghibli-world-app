package com.marianunez.ghibliworld.data.network

import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import com.marianunez.ghibliworld.data.network.response.LocationsResponse
import com.marianunez.ghibliworld.data.network.response.PeopleResponse
import com.marianunez.ghibliworld.data.network.response.SpeciesResponse
import com.marianunez.ghibliworld.data.network.response.VehiclesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRestService {

    @GET(ApiConstants.FILMS)
    suspend fun getFilms(
        @Query("limit") limit: Int = 40,
        @Query("ts") timeStamp: String,
        @Query("orderBy") orderBy: String
    ): List<FilmsResponse>

    @GET(ApiConstants.FILM_DETAIL)
    suspend fun getFilmDetail(@Path("id") filmId: String): FilmsResponse

    @GET(ApiConstants.PEOPLE)
    suspend fun getPeople(@Query("limit") limit: Int = 20): PeopleResponse

    @GET(ApiConstants.LOCATIONS)
    suspend fun getLocations(@Query("limit") limit: Int = 20): LocationsResponse

    @GET(ApiConstants.SPECIES)
    suspend fun getSpecies(@Query("limit") limit: Int = 20): SpeciesResponse

    @GET(ApiConstants.VEHICLES)
    suspend fun getVehicles(@Query("limit") limit: Int = 20): VehiclesResponse
}