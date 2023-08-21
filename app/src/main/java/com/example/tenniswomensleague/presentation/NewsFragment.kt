package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenniswomensleague.databinding.FragmentNewsBinding
import com.example.tenniswomensleague.presentation.adapter.NewsAdapter
import com.example.tenniswomensleague.viewModel.NewsViewModel
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainATennisActivity

class NewsFragment : Fragment() {
    private var _binding : FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        observeNewsData()
        binding.ivInfoNews.setOnClickListener { Toast.makeText(context, R.string.info_news, Toast.LENGTH_SHORT).show() }
        binding.ivBackMenu.setOnClickListener { replaceFragmentMainATennisActivity(MenuFragment()) }
    }

    private fun observeNewsData() {
        val viewModel : NewsViewModel = ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)

        binding.rvNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvNews.adapter = adapter

        viewModel.getResultMatch().observe(requireActivity()){news ->
            adapter.setItem(news)
        }


    }
}