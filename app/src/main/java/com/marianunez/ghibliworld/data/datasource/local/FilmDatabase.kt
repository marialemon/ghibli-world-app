package com.marianunez.ghibliworld.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marianunez.ghibliworld.data.datasource.local.dao.FilmListDao
import com.marianunez.ghibliworld.domain.model.FilmsLocalEntity

@Database(
    entities = [FilmsLocalEntity::class],
    version = 1
)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun getFilmsDao(): FilmListDao

    companion object {
        @Volatile // means that other threads can see when this instance is changed
        private var instance: FilmDatabase? = null
        private val LOCK = Any() // to make sure that there is only one instance at once

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            /**
             * everything that happens inside this block can NOT be accessed
             * by other threads at the same time
             * */
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FilmDatabase::class.java,
                "film_db.db"
            ).build()

    }
}