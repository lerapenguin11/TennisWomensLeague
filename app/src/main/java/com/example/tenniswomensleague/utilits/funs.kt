package com.example.tenniswomensleague.presentation.utilits

import androidx.fragment.app.Fragment
import com.example.tenniswomensleague.APP_MAIN_ACTIVITY
import com.example.tenniswomensleague.R

fun replaceFragmentMainActivity(fr: Fragment, addSt: Boolean = true) {
    if (addSt) {
        APP_MAIN_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.main_layout,
                fr
            ).commit()
    } else {
        APP_MAIN_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_layout,
                fr
            ).commit()
    }
}