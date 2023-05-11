package com.example.roomdbbatch3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdbbatch3.database.AppDatabase
import com.example.roomdbbatch3.databinding.ActivitySecondBinding
import com.example.roomdbbatch3.model.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var myDb: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDb = AppDatabase.initDatabase(this)

        binding.saveN.setOnClickListener {
            val title = binding.titleET.text.toString()
            val description = binding.descET.text.toString()
            val note = NoteModel(null, title, description)

            GlobalScope.launch {
                myDb.noteDao().insert(note)
            }
            Toast.makeText(this, "Note added successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}