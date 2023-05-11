package com.example.roomdbbatch3.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbbatch3.model.NoteModel

@Dao
interface NoteDao {
    @Insert
    fun insert(noteModel: NoteModel)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<NoteModel>
}