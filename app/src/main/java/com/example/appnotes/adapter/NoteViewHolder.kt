package com.example.appnotes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotes.databinding.ItemNoteBinding
import com.example.appnotes.model.Note
import com.example.appnotes.model.NoteEntity

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val bind = ItemNoteBinding.bind(itemView)

    fun render(noteCurrent: Note, onClickList: (Note) -> Unit){
        bind.itemTvTittle.text = noteCurrent.title
        itemView.setOnClickListener { onClickList(noteCurrent) }
    }


}