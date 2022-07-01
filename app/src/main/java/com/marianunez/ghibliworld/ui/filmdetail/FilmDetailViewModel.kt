package com.marianunez.ghibliworld.ui.filmdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marianunez.ghibliworld.data.datasource.cloud.FilmDetailCloudDataSource
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.repository.FilmDetailRepositoryImpl
import com.marianunez.ghibliworld.domain.FilmDetailUseCase
import com.marianunez.ghibliworld.domain.model.FilmsModel
import kotlinx.coroutines.launch

class FilmDetailViewModel : ViewModel() {

    private val filmDetailUseCase = FilmDetailUseCase(
        filmDetailRepository = FilmDetailRepositoryImpl(
            filmDetailCloudDataSource = FilmDetailCloudDataSource(apiFactoryService = ApiFactoryService())))

    private val _filmDetail = MutableLiveData<FilmsModel>()
    val filmDetail: LiveData<FilmsModel> = _filmDetail

    fun getFilmDetail(filmId: String) {
        viewModelScope.launch {
            filmDetailUseCase.getFilmDetail(filmId)
                .onSuccess { _filmDetail.postValue(it) }
                .onFailure { throw Exception("Aquí una excepción") }
        }
    }
}