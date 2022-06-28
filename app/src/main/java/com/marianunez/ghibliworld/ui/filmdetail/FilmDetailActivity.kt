package com.marianunez.ghibliworld.ui.filmdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.marianunez.ghibliworld.databinding.ActivityFilmDetailBinding

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
        val id = intent.extras?.getString("id") ?: ""
        val title = intent.extras?.getString("title") ?: ""
        val description = intent.extras?.getString("description") ?: ""

        viewModel.getFilmDetail(id)
        // viewModel.filmDetail.observe(this) { film -> binding.filmTitle.text = film.title }

        binding.filmTitle.text = title
        binding.filmDescription.text = description
    }
}