package com.example.tenniswomensleague.presentation.notes

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.business.db.Notes
import com.example.tenniswomensleague.databinding.FragmentNewNoteBinding
import com.example.tenniswomensleague.databinding.FragmentNotesBinding
import com.example.tenniswomensleague.viewModel.NotesViewModel

class NewNoteFragment : Fragment() {
    private var _binding : FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModal : NotesViewModel
    var noteID = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application = requireActivity().application)
        ).get(NotesViewModel::class.java)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        newNote()
    }

    private fun newNote() {
        binding.btSaveNotes.setOnClickListener {
            val noteTitle = binding.enterTitleNotes.text.toString()
            val noteText = binding.enterTextNotes.text.toString()

            if (noteTitle.isNotEmpty() && noteText.isNotEmpty()) {
                viewModal.addNote(Notes(title = noteTitle, textNote = noteText))
                Toast.makeText(context, "$noteTitle Added", Toast.LENGTH_LONG).show()
                binding.enterTextNotes.text.clear()
                binding.enterTitleNotes.text.clear()
            }
        }
    }
}