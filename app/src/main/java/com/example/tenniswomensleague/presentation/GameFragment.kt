package com.example.tenniswomensleague.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.databinding.FragmentGameBinding
import com.example.tenniswomensleague.presentation.utilits.replaceFragmentMainATennisActivity
import java.util.*

class GameFragment : Fragment() {

    private var _binding : FragmentGameBinding? = null
    private val binding get() = _binding!!

    private var ballPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGameBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        ballPosition = Random().nextInt(3)

        binding.cup1.setOnClickListener { checkAnswer(0) }
        binding.cup2.setOnClickListener { checkAnswer(1) }
        binding.cup3.setOnClickListener { checkAnswer(2) }

        onClick()
    }

    private fun checkAnswer(position: Int) {
        if (position == ballPosition) {
            when(position){
                0 -> binding.cup1.setImageResource(R.drawable.ic_group_cup)
                1 -> binding.cup2.setImageResource(R.drawable.ic_group_cup)
                2 -> binding.cup3.setImageResource(R.drawable.ic_group_cup)
            }
            showResultMessage("Congratulations, you guessed it!")
        } else {
            showResultMessage("Unfortunately, you did not guess.")
        }

        binding.cup1.isEnabled = false
        binding.cup2.isEnabled = false
        binding.cup3.isEnabled = false
    }

    private fun showResultMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun onClick() {
        binding.btStartGame.setOnClickListener {
            binding.btStartGame.visibility = View.INVISIBLE
            binding.block.visibility = View.INVISIBLE
        }

        binding.ivBackMenu.setOnClickListener {
            replaceFragmentMainATennisActivity(InteractiveFragment())
            binding.btStartGame.visibility = View.VISIBLE
        }

        binding.ivRefresh.setOnClickListener {

            binding.cup1.setImageResource(R.drawable.ic_cup)
            binding.cup2.setImageResource(R.drawable.ic_cup)
            binding.cup3.setImageResource(R.drawable.ic_cup)

            ballPosition = Random().nextInt(3)

            binding.cup1.setOnClickListener { checkAnswer(0) }
            binding.cup2.setOnClickListener { checkAnswer(1) }
            binding.cup3.setOnClickListener { checkAnswer(2) }

            binding.cup1.isEnabled = true
            binding.cup2.isEnabled = true
            binding.cup3.isEnabled = true
        }
    }
}