package com.example.tenniswomensleague.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tenniswomensleague.presentation.notes.ListNotesFragment
import com.example.tenniswomensleague.presentation.notes.NewNoteFragment

class NotesPagerAdapter(
    fragment : FragmentManager,
    lifecycle : Lifecycle) : FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            NewNoteFragment()
        } else ListNotesFragment()
    }
}