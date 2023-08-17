package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenniswomensleague.databinding.FragmentMatchBinding
import com.example.tenniswomensleague.presentation.adapter.MatchAdapter
import com.example.tenniswomensleague.viewModel.MatchViewModel

class MatchFragment : Fragment() {
    private var _binding : FragmentMatchBinding? = null
    private val binding get() = _binding!!

    private val adapter = MatchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMatchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        observeMatchData()
    }

    private fun observeMatchData() {
        binding.rvMatch.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMatch.adapter = adapter

        val viewModel : MatchViewModel = ViewModelProvider(requireActivity()).get(MatchViewModel::class.java)

        viewModel.getResultMatch().observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })
    }

}