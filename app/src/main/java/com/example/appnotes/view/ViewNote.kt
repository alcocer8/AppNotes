package com.example.appnotes.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.appnotes.AppDatabase
import com.example.appnotes.R
import com.example.appnotes.databinding.ActivityViewNoteBinding
import com.example.appnotes.funtions.deleteNote
import com.example.appnotes.funtions.showMensage
import com.example.appnotes.funtions.updateNote
import com.example.appnotes.model.Note
import com.example.appnotes.model.NoteEntity

class ViewNote : AppCompatActivity() {

    private lateinit var bind: ActivityViewNoteBinding
    private lateinit var db: AppDatabase
    private lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityViewNoteBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setSupportActionBar(bind.toolbar)

        db = AppDatabase.initDb(this)
        note = getNoteOfBundle()!!

        setNoteOnEdit(note)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.delete_note -> {
                deleteNote(NoteEntity(
                    note.id,
                    note.title,
                    note.text
                ), this, db)
                finish()
            }

            R.id.edit_note -> {
                updateNote(NoteEntity(
                    note.id,
                    bind.viewEtTittle.text.toString(),
                    bind.viewEtText.text.toString()
                ), this, db)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getNoteOfBundle(): Note? = intent.getParcelableExtra("note")

    private fun setNoteOnEdit(note: Note) {
        bind.viewEtTittle.setText(note.title)
        bind.viewEtText.setText(note.text)
    }
}