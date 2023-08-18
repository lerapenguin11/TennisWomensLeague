package com.example.tenniswomensleague.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.business.db.Notes

class NotesListAdapter() : RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder>(){

    private val allNotes = ArrayList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)

        return NotesListViewHolder(view)
    }

    override fun getItemCount(): Int = allNotes.size

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        val note : Notes = allNotes[position]

        holder.title.text = note.title
        holder.textNote.text = note.textNote
    }

    fun setItem(newList: List<Notes>) {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    class NotesListViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_title_note)
        val textNote : TextView = view.findViewById(R.id.tv_text_note)
    }
}