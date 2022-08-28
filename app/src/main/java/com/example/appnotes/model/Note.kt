package com.example.appnotes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id : Int,
    var title : String,
    var text : String
) : Parcelable
