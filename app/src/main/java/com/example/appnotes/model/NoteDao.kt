package com.example.appnotes.model

import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM NoteEntity")
    fun getAllNote(): List<Note>

    @Query("SELECT * FROM NoteEntity WHERE id=:id")
    fun getNoteForID(id: Int): Note

    @Insert
    fun insertNote(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)


}