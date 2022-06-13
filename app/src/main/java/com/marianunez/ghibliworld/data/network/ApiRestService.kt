package com.marianunez.ghibliworld.data.network

import com.marianunez.ghibliworld.data.network.response.FilmsResponse
import com.marianunez.ghibliworld.data.network.response.LocationsResponse
import com.marianunez.ghibliworld.data.network.response.PeopleResponse
import com.marianunez.ghibliworld.data.network.response.SpeciesResponse
import com.marianunez.ghibliworld.data.network.response.VehiclesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRestService {

    @GET(ApiConstants.FILMS)
    fun getFilms(@Query("limit") limit: Int = 20): FilmsResponse

    @GET(ApiConstants.PEOPLE)
    fun getPeople(@Query("limit") limit: Int = 20): PeopleResponse

    @GET(ApiConstants.LOCATIONS)
    fun getLocations(@Query("limit") limit: Int = 20): LocationsResponse

    @GET(ApiConstants.SPECIES)
    fun getSpecies(@Query("limit") limit: Int = 20): SpeciesResponse

    @GET(ApiConstants.VEHICLES)
    fun getVehicles(@Query("limit") limit: Int = 20): VehiclesResponse
}