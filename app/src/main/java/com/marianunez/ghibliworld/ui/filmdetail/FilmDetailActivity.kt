package com.marianunez.ghibliworld.ui.filmdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marianunez.ghibliworld.databinding.ActivityFilmDetailBinding

class FilmDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}