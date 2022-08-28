package com.example.appnotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey val id : Int?,
    val title:String,
    val text: String
)
