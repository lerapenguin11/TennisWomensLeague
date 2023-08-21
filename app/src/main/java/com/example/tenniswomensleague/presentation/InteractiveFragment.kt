package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.databinding.FragmentInteractiveBinding
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainATennisActivity

class InteractiveFragment : Fragment() {
    private var _binding : FragmentInteractiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInteractiveBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.playNow.setOnClickListener { replaceFragmentMainATennisActivity(GameFragment()) }
        binding.ivBackMenu.setOnClickListener { replaceFragmentMainATennisActivity(MenuFragment()) }
        binding.ivInfoInteractive.setOnClickListener { Toast.makeText(context, R.string.info_interactive, Toast.LENGTH_SHORT).show() }
    }
}