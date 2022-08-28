package com.example.appnotes.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.appnotes.AppDatabase
import com.example.appnotes.R
import com.example.appnotes.databinding.ActivityAddNoteBinding
import com.example.appnotes.funtions.clearEditText
import com.example.appnotes.funtions.saveNote
import com.example.appnotes.model.NoteEntity

class AddNote : AppCompatActivity() {

    private lateinit var bind: ActivityAddNoteBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setSupportActionBar(bind.toolbar)


        //AppDatabase
        db = Room.databaseBuilder(this, AppDatabase::class.java, "Notes").build()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_note -> {
                saveNote(NoteEntity(
                    null,
                    bind.addEtTitle.text.toString(),
                    bind.addEtText.text.toString()
                ), this, db)
                clearEditText(bind.addEtTitle)
                clearEditText(bind.addEtText)
            }

        }
        return super.onOptionsItemSelected(item)
    }




}