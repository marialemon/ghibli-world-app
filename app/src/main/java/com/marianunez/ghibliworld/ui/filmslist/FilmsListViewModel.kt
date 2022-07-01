package com.marianunez.ghibliworld.ui.filmslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marianunez.ghibliworld.data.datasource.cloud.FilmsListCloudDataSource
import com.marianunez.ghibliworld.data.network.ApiFactoryService
import com.marianunez.ghibliworld.data.repository.FilmsListRepositoryImpl
import com.marianunez.ghibliworld.domain.FilmsListUseCase
import com.marianunez.ghibliworld.domain.model.FilmsModel
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {

    //this is WHY we use Koin for di
    private val filmsListUseCase = FilmsListUseCase(
        filmsListRepository = FilmsListRepositoryImpl(
            filmsListCloudDataSource = FilmsListCloudDataSource(
                apiFactoryService = ApiFactoryService()
            )
        )
    )

    private val _filmsList = MutableLiveData<List<FilmsModel>>()
    val filmsList: LiveData<List<FilmsModel>> = _filmsList

    fun getFilmsList() {
        viewModelScope.launch {
            filmsListUseCase.getFilmsList()
                .onSuccess { _filmsList.postValue(it) }
                .onFailure { throw Exception("Errrrrror") }
        }
    }
}