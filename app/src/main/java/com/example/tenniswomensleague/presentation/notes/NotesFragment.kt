package com.example.tenniswomensleague.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.databinding.FragmentNotesBinding
import com.example.tenniswomensleague.presentation.MenuFragment
import com.example.tenniswomensleague.presentation.adapter.NotesPagerAdapter
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainActivity
import com.google.android.material.tabs.TabLayout

class NotesFragment : Fragment() {
    private var _binding : FragmentNotesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : NotesPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotesBinding.inflate(inflater, container, false)

        adapter = NotesPagerAdapter(requireFragmentManager(), lifecycle)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("New note"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("List of notes"))
        binding.ivInfoNotes.setOnClickListener { Toast.makeText(context, R.string.info_notes, Toast.LENGTH_LONG).show() }
        binding.ivBackMenu.setOnClickListener { replaceFragmentMainActivity(MenuFragment()) }

        binding.viewPager2.adapter = adapter

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

        return binding.root
    }
}