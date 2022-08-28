package com.example.appnotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotes.R
import com.example.appnotes.model.Note
import com.example.appnotes.model.NoteEntity

class NoteAdapter(val notes: List<Note>, private val onClickList: (Note) -> Unit) : RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
        return NoteViewHolder(view.inflate(R.layout.item_note, parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.render(notes[position], onClickList)

    override fun getItemCount(): Int = notes.size

}