package com.marianunez.ghibliworld.ui.filmdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marianunez.ghibliworld.domain.model.FilmsModel

class FilmDetailViewModel : ViewModel() {

    private val _filmDetail = MutableLiveData<FilmsModel>()
    val filmDetail: LiveData<FilmsModel> = _filmDetail

}