package com.example.tenniswomensleague.presentation

import android.R
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tenniswomensleague.business.models.MatchModel
import com.example.tenniswomensleague.databinding.FragmentMatchBinding
import com.example.tenniswomensleague.presentation.adapter.MatchAdapter
import com.example.tenniswomensleague.presentation.adapter.listener.MatchHistoryListener
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainActivity
import com.example.tenniswomensleague.viewModel.MatchViewModel

class MatchFragment : Fragment(), MatchHistoryListener {
    private var _binding : FragmentMatchBinding? = null
    private val binding get() = _binding!!

    private val adapter = MatchAdapter(this)

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
        binding.ivInfoMatch.setOnClickListener { Toast.makeText(context, com.example.tenniswomensleague.R.string.info_match, Toast.LENGTH_SHORT).show() }
        binding.ivBackMenu.setOnClickListener { replaceFragmentMainActivity(MenuFragment()) }
    }

    private fun observeMatchData() {
        binding.rvMatch.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMatch.adapter = adapter

        val viewModel : MatchViewModel = ViewModelProvider(requireActivity()).get(MatchViewModel::class.java)

        viewModel.getResultMatch().observe(viewLifecycleOwner, Observer {
            adapter.setItem(it)
        })
    }

    override fun historyMatch(lastMatch: MatchModel) {
        val dialog = Dialog(requireContext(), R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(com.example.tenniswomensleague.R.layout.full_screen_dialog_match_history)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val nameLeft : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_name_left)
        val nameRight : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_name_right)
        val resultLeftOne : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_result_left_one)
        val resultLeftTwo : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_result_left_second)
        val resultRightOne : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_result_right_one)
        val resultRightTwo : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_result_right_second)
        val nameLeftResult : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_name_left_history)
        val nameRightResult : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_name_right_history)
        val nameLeftMetrics : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_name_left_metrics)
        val nameRightMetrics : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_name_metrics)
        val leftWtaSinglesRankings : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_wta_singles_rankings)
        val leftAge : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_age)
        val leftHeight : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_height)
        val leftPlays : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_plays)
        val leftCoach : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_coach)
        val leftMatchesPlayed : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_matches_played)
        val leftAces : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_aces)
        val leftServiceGamesWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_service_games_won)
        val leftFeturnGamesWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left_return_games_won)
        val left1stServeWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_left__1st_serve_won)
        val rightWtaSinglesRankings : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_wta_singles_rankings)
        val rightHeight : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_height)
        val rightPlays : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_plays)
        val rightCoach : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_coach)
        val rightMatchesPlayed : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_matches_played)
        val rightAces : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_aces)
        val rightServiceGamesWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_service_games_won)
        val rightReturnGamesWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_return_games_won)
        val right1stServeWon : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_1st_serve_won)
        val rightAge : TextView = dialog.findViewById(com.example.tenniswomensleague.R.id.tv_right_age)
        val flagLeft : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_flag_left)
        val flagRight : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_flag_right)
        val flagLeftHistory : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_flag_left_history)
        val flagRightHistory : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_flag_right_history)
        val btBack : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.imageView2)
        val info_history : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_info_match_history)
        val iconWinLeft : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_left_win)
        val iconWinRight : ImageView = dialog.findViewById(com.example.tenniswomensleague.R.id.iv_right_win)

        val resultLeft = lastMatch.resultLeftTwo + lastMatch.resultLeftTwo
        val resultRight = lastMatch.resultRightOne + lastMatch.resultLeftTwo

        if(resultLeft > resultRight){
            iconWinLeft.visibility = View.VISIBLE
        } else {
            iconWinRight.visibility = View.VISIBLE
        }

        btBack.setOnClickListener { dialog.cancel() }
        info_history.setOnClickListener { Toast.makeText(context, com.example.tenniswomensleague.R.string.info_history,
        Toast.LENGTH_SHORT).show() }

        rightWtaSinglesRankings.text = lastMatch.rightWtaSinglesRankings
        rightHeight.text = lastMatch.rightHeight
        rightPlays.text = lastMatch.rightPlays
        rightCoach.text = lastMatch.rightCoach
        rightMatchesPlayed.text = lastMatch.rightMatchesPlayed
        rightAces.text = lastMatch.rightAces
        rightServiceGamesWon.text = lastMatch.rightServiceGamesWon
        rightReturnGamesWon.text = lastMatch.rightReturnGamesWon
        right1stServeWon.text = lastMatch.right1stServeWon
        rightAge.text = lastMatch.rightAge

        nameLeft.text = lastMatch.nameLeft
        nameRight.text = lastMatch.nameRight
        resultLeftOne.text = lastMatch.resultLeftOne.toString()
        resultLeftTwo.text = lastMatch.resultLeftTwo.toString()
        resultRightOne.text = lastMatch.resultRightOne.toString()
        resultRightTwo.text = lastMatch.resultRightTwo.toString()
        nameLeftResult.text = lastMatch.nameLeftResult
        nameRightResult.text = lastMatch.nameRightResult
        nameLeftMetrics.text = lastMatch.nameLeftMetrics
        nameRightMetrics.text = lastMatch.nameRightMetrics
        left1stServeWon.text = lastMatch.left1stServeWon
        leftAces.text = lastMatch.leftAces
        leftAge.text = lastMatch.leftAge
        leftCoach.text = lastMatch.leftCoach
        leftHeight.text = lastMatch.leftHeight
        leftWtaSinglesRankings.text = lastMatch.leftWtaSinglesRankings
        leftPlays.text = lastMatch.leftPlays
        leftMatchesPlayed.text = lastMatch.leftMatchesPlayed
        leftServiceGamesWon.text = lastMatch.leftServiceGamesWon
        leftFeturnGamesWon.text = lastMatch.leftFeturnGamesWon

        Glide.with(requireContext())
            .load(lastMatch.flagLeft)
            .override(22, 12)
            .into(flagLeft)

        Glide.with(requireContext())
            .load(lastMatch.flagRight)
            .override(22, 12)
            .into(flagRight)

        Glide.with(requireContext())
            .load(lastMatch.flagLeftHistory)
            .override(21, 11)
            .into(flagLeftHistory)

        Glide.with(requireContext())
            .load(lastMatch.flagRightHistory)
            .override(21, 11)
            .into(flagRightHistory)

        dialog.show()
    }

}