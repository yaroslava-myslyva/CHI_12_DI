package com.example.chi_12_di.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chi_12_di.data.db.dao.PhotosDao
import com.example.chi_12_di.data.db.model.PhotoEntity
import kotlinx.coroutines.CoroutineScope

@Database(
    version = 1,
    entities = [
        PhotoEntity::class
    ]
)
abstract class PhotosDataBase : RoomDatabase() {

    abstract val photosDao: PhotosDao

    companion object {
        private const val DB_NAME = "photosDataBase"

        @Volatile
        private var instance: PhotosDataBase? = null

        fun getDataBase(
            context: Context,
            scope: CoroutineScope
        ): PhotosDataBase {
            return instance ?: synchronized(this) {

                val newDb = Room.databaseBuilder(
                    context.applicationContext,
                    PhotosDataBase::class.java,
                    DB_NAME
                )
                    .build()
                instance = newDb
                newDb
            }
        }
    }

}