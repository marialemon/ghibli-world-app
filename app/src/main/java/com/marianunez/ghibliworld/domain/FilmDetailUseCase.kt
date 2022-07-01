package com.marianunez.ghibliworld.domain

import com.marianunez.ghibliworld.data.repository.FilmDetailRepository
import com.marianunez.ghibliworld.domain.model.FilmsModel
import com.marianunez.ghibliworld.domain.model.mapper.toModel

class FilmDetailUseCase(private val filmDetailRepository: FilmDetailRepository) {

    suspend fun getFilmDetail(filmId: String): Result<FilmsModel> {
        return filmDetailRepository.getFilmDetail(filmId).map {
            it.toModel()
        }
    }
}