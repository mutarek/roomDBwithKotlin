package com.example.roomdbbatch3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbbatch3.dao.NoteDao
import com.example.roomdbbatch3.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun initDatabase(context: Context): AppDatabase {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "ssancjasncjsan"
            ).build()
            INSTANCE = instance
            return instance
        }

    }
}