package com.marianunez.ghibliworld.domain

import com.marianunez.ghibliworld.data.repository.FilmsListRepository
import com.marianunez.ghibliworld.domain.model.FilmsModel
import com.marianunez.ghibliworld.domain.model.mapper.toModel

class FilmsListUseCase(private val filmsListRepository: FilmsListRepository) {

    suspend fun getFilmsList(): Result<List<FilmsModel>> {
        val response = filmsListRepository.getFilmsList()
        return response.map { resultListFilmsResponse ->
            resultListFilmsResponse.map { filmsResponseItem -> filmsResponseItem.toModel() }
        }
    }
}