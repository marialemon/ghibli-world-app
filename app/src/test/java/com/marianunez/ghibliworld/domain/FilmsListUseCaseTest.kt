package com.marianunez.ghibliworld.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.marianunez.ghibliworld.data.repository.FilmsListRepositoryImpl
import com.marianunez.ghibliworld.fakedata.fakeFilmsListModel
import com.marianunez.ghibliworld.fakedata.fakeFilmsListResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FilmsListUseCaseTest {
    private val filmsListRepository = mockk<FilmsListRepositoryImpl>()
    private val filmsListUseCase = FilmsListUseCase(filmsListRepository)

    @Test
    fun transformation_from_Response_to_Model_when_result_is_Success() {
        runBlocking {
            coEvery {
                filmsListRepository.getFilmsList()
            } returns Result.success(fakeFilmsListResponse)

            val actual = filmsListUseCase.getFilmsList()
            assertThat(actual.getOrThrow()).isEqualTo(fakeFilmsListModel)

        }
    }
}