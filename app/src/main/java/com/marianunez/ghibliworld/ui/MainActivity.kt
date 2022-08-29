package com.marianunez.ghibliworld.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marianunez.ghibliworld.R
import com.marianunez.ghibliworld.databinding.ActivityMainBinding
import com.marianunez.ghibliworld.ui.filmslist.FilmsListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        onMenuItemSelected()
    }

    private fun onMenuItemSelected() {
        val filmsListFragment = FilmsListFragment()
        val characterListFragment = CharacterListFragment()
        setCurrentFragment(filmsListFragment)

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavBar)
        bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_films -> {
                    setCurrentFragment(filmsListFragment)
                    true
                }
                R.id.action_characters -> {
                    setCurrentFragment(characterListFragment)
                    true
                }
                R.id.action_favorites -> true
                else -> super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_content_main, fragment)
            commit()
        }
}