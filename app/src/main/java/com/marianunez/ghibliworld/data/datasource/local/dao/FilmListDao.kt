package com.marianunez.ghibliworld.data.datasource.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marianunez.ghibliworld.domain.model.FilmsLocalEntity

@Dao
interface FilmListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // si ya existe, reemplazala
    suspend fun insertFilm(film: FilmsLocalEntity): Long

    @Query("SELECT * FROM filmsList")
    // no será suspend fun porque retornará un LiveData y esto no funciona con suspend functions
    fun getFilms(): LiveData<List<FilmsLocalEntity>>

    @Delete
    suspend fun deleteFilm(film: FilmsLocalEntity)

}