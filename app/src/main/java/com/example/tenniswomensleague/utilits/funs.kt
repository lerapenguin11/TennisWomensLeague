package com.example.tenniswomensleague.presentation.utilits

import androidx.fragment.app.Fragment
import com.example.tenniswomensleague.APP_MAIN_ACTIVITY_TENNIS
import com.example.tenniswomensleague.R

fun replaceFragmentMainATennisActivity(frag: Fragment, adSt: Boolean = true) {
    if (adSt) {
        APP_MAIN_ACTIVITY_TENNIS.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.main_layout,
                frag
            ).commit()
    } else {
        APP_MAIN_ACTIVITY_TENNIS.supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_layout,
                frag
            ).commit()
    }
}