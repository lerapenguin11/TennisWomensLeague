package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tenniswomensleague.databinding.FragmentMenuBinding
import com.example.tenniswomensleague.presentation.notes.NotesFragment
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainATennisActivity

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
        binding.navMatch.setOnClickListener {
            replaceFragmentMainATennisActivity(MatchFragment())
        }
        binding.navNews.setOnClickListener {
            replaceFragmentMainATennisActivity(NewsFragment())
        }
        binding.navNotes.setOnClickListener {
            replaceFragmentMainATennisActivity(NotesFragment())
        }
        binding.navGame.setOnClickListener {
            replaceFragmentMainATennisActivity(InteractiveFragment())
        }
    }
}