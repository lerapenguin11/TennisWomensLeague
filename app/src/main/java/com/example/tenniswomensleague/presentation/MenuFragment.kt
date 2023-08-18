package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.databinding.FragmentMenuBinding
import com.example.tenniswomensleague.presentation.notes.NotesFragment
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainActivity

class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.navMatch.setOnClickListener { replaceFragmentMainActivity(MatchFragment()) }
        binding.navNews.setOnClickListener { replaceFragmentMainActivity(NewsFragment()) }
        binding.navNotes.setOnClickListener { replaceFragmentMainActivity(NotesFragment()) }
    }
}