package com.example.appnotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appnotes.model.NoteEntity
import com.example.appnotes.model.NoteDao

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        fun initDb(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "Notes")
                .build()
    }
}