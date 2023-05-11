package com.example.roomdbbatch3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbbatch3.database.AppDatabase
import com.example.roomdbbatch3.databinding.ActivityMainBinding
import com.example.roomdbbatch3.model.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mydb: AppDatabase
    private lateinit var mydataList: ArrayList<NoteModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mydb = AppDatabase.initDatabase(this)
        getLocalData()

        binding.favB.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getLocalData() {
        mydataList = arrayListOf()
        GlobalScope.launch {
            mydb.noteDao().getAllNotes().forEach { singledata ->
                mydataList.add(singledata)
            }
            inintRecyllerView()
        }
    }

    private fun inintRecyllerView() {
        binding.recyllerView.layoutManager = LinearLayoutManager(this)
        binding.recyllerView.adapter = CustomAdapter(mydataList)
    }

}