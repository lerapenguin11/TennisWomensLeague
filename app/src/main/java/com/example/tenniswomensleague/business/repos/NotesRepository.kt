package com.example.tenniswomensleague.business.repos

import androidx.lifecycle.LiveData
import com.example.tenniswomensleague.business.db.Notes
import com.example.tenniswomensleague.business.db.NotesDao

class NotesRepository(private val notesDao: NotesDao) {

    val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insert(note: Notes) {
        notesDao.insert(note)
    }

    suspend fun delete(note: Notes){
        notesDao.delete(note)
    }

    suspend fun update(note: Notes){
        notesDao.update(note)
    }
}