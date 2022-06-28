package com.marianunez.ghibliworld.data.repository

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.marianunez.ghibliworld.data.datasource.cloud.FilmsListCloudDataSource
import com.marianunez.ghibliworld.fakedata.fakeFilmsListResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FilmsListRepositoryImplTest {
    private val filmsListCloudDataSource = mockk<FilmsListCloudDataSource>()

    // sut -> system under test
    private val sut = FilmsListRepositoryImpl(filmsListCloudDataSource)

    @Test
    fun get_films_list_OK() = runBlocking {
        // si no ponemos runBloquing dará un error de que la función tiene que ser suspend
        coEvery { filmsListCloudDataSource.getFilmsList() } returns fakeFilmsListResponse
        val actual = sut.getFilmsList()
        assertThat(actual).isEqualTo(fakeFilmsListResponse)
    }
}