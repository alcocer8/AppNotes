package com.example.appnotes.funtions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotes.AppDatabase
import com.example.appnotes.adapter.NoteAdapter
import com.example.appnotes.model.Note
import com.example.appnotes.model.NoteEntity
import com.example.appnotes.view.AddNote
import com.example.appnotes.view.ViewNote
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun showMensage(text: String, context: Context) =
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

fun saveNote(note: NoteEntity, context: Context, db: AppDatabase) {

    if (note.title.isEmpty() || note.text.isEmpty()) return

    GlobalScope.launch {
        db.noteDao().insertNote(note)
    }

    showMensage("Dato ingresado", context)
}

fun updateNote(note: NoteEntity, context: Context, db: AppDatabase) {
    if (note.title.isEmpty() || note.text.isEmpty()) return

    GlobalScope.launch { db.noteDao().updateNote(note) }
    showMensage("Update Note", context)
}

fun deleteNote(note: NoteEntity, context: Context, db: AppDatabase){
    GlobalScope.launch { db.noteDao().deleteNote(note) }
    showMensage("Delete Note", context)
}

fun clearEditText(editText: EditText) = editText.text.clear()

fun changeView(name: String, context: Context, note: Note? = null) {
    val intent: Intent = when (name) {
        "Add" -> Intent(context, AddNote::class.java)
        "View" -> {
            Intent(context, ViewNote::class.java).putExtra("note", note)
        }
        else -> return
    }

    startActivity(context, intent, null)

}

fun initRecyclerNote(recyclerView: RecyclerView, notes: List<Note>, context: Context) {
    recyclerView.layoutManager = LinearLayoutManager(context)
    recyclerView.adapter = NoteAdapter(notes) { changeView("View", context, it) }
}


