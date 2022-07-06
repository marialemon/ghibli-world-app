package com.marianunez.ghibliworld.data.datasource

import assertk.assertions.isEqualTo
import com.marianunez.ghibliworld.data.datasource.cloud.FilmsListCloudDataSource
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.fakedata.fakeFilmsListResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class FilmsListCloudDataSourceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var filmsListCloudDataSource: FilmsListCloudDataSource

    @Before
    fun setUp() {
        mockWebServer.start(8080)
        val fakeUrl = mockWebServer.url("/").toString()
        filmsListCloudDataSource = FilmsListCloudDataSource(ApiFactoryService(), fakeUrl)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should return filmsList when response is 200ok`(): Unit = runBlocking {
        val jsonFilmsListResponse = this.javaClass.classLoader
            .getResourceAsStream("assets/filmsListResponse.json")
            .bufferedReader().use { it.readText() } // buffer -> almacén de datos
        val response = MockResponse()
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .addHeader("Cache-Control", "no-cache")
            .setBody(jsonFilmsListResponse)

        mockWebServer.enqueue(response)

        val actual = filmsListCloudDataSource.getFilmsList()

        assertk.assertThat(actual.getOrThrow()).isEqualTo(fakeFilmsListResponse)
    }
}