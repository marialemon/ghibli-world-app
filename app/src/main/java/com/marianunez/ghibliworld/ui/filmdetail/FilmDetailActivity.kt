package com.marianunez.ghibliworld.ui.filmdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.marianunez.ghibliworld.databinding.ActivityFilmDetailBinding
import com.marianunez.ghibliworld.ui.FILM_DESCRIPTION
import com.marianunez.ghibliworld.ui.FILM_ID
import com.marianunez.ghibliworld.ui.FILM_TITLE

class FilmDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmDetailBinding
    private lateinit var viewModel: FilmDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[FilmDetailViewModel::class.java]

        initUI()
    }

    private fun initUI() {
        val id = intent.extras?.getString(FILM_ID) ?: ""
        val title = intent.extras?.getString(FILM_TITLE) ?: ""
        val description = intent.extras?.getString(FILM_DESCRIPTION) ?: ""

        viewModel.getFilmDetail(id)
        // viewModel.filmDetail.observe(this) { film -> binding.filmTitle.text = film.title }

        binding.filmTitle.text = title
        binding.filmDescription.text = description
    }
}