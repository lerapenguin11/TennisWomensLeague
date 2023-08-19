package com.example.tenniswomensleague.presentation.OnBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingTennisAdapter (arrayList : ArrayList<Fragment>, fm : FragmentManager, lifecycle : Lifecycle)
    : FragmentStateAdapter(fm, lifecycle) {

    private val fragmentListOnBoarding = arrayList

    override fun getItemCount(): Int = fragmentListOnBoarding.size

    override fun createFragment(position: Int): Fragment = fragmentListOnBoarding[position]
}