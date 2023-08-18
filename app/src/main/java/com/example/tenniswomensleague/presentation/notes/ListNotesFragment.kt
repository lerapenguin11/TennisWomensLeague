package com.example.tenniswomensleague.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.databinding.FragmentListNotesBinding
import com.example.tenniswomensleague.databinding.FragmentNewNoteBinding
import com.example.tenniswomensleague.presentation.adapter.NotesListAdapter
import com.example.tenniswomensleague.viewModel.NotesViewModel

class ListNotesFragment : Fragment() {
    private var _binding : FragmentListNotesBinding? = null
    private val binding get() = _binding!!

    private val adapter = NotesListAdapter()
    private lateinit var viewModal : NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListNotesBinding.inflate(inflater, container, false)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application = requireActivity().application)
        ).get(NotesViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        observeNotesData()
    }

    private fun observeNotesData() {
        binding.rvListNotes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvListNotes.adapter = adapter

        viewModal.allNotes.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                adapter.setItem(it)
            }
        })
    }
}