package com.example.appnotes.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.appnotes.AppDatabase
import com.example.appnotes.R
import com.example.appnotes.databinding.ActivityMainBinding
import com.example.appnotes.funtions.changeView
import com.example.appnotes.funtions.initRecyclerNote
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setSupportActionBar(bind.toolbar)

        db = AppDatabase.initDb(this)

        GlobalScope.launch {
            initRecyclerNote(
                bind.rc1,
                db.noteDao().getAllNote(),
                bind.rc1.context
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_note -> changeView(
                "Add",
                this
            )
        }
        return super.onOptionsItemSelected(item)
    }

}