package com.example.tenniswomensleague.presentation.OnBoarding

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tenniswomensleague.R
import com.example.tenniswomensleague.presentation.MainActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardingTennisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_tennis)

        setViewPager()
        setStatusBarGradiant(this)
    }

    private fun setViewPager() {
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(ThirstFragmentTennis())
        fragmentList.add(SecondFragmentTennis())
        fragmentList.add(ThirdFragmentTemmis())
        val adapterViewPager = OnBoardingTennisAdapter(
            fragmentList,
            this.supportFragmentManager,
            lifecycle
        )
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapterViewPager
        val indicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        indicator.attachTo(viewPager)
        val finish = findViewById<ImageView>(R.id.finish)
        finish.setOnClickListener { v: View? ->
            val intent = Intent(
                this@OnBoardingTennisActivity,
                MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBarGradiant(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = activity.window
            val background = ContextCompat.getDrawable(activity, R.color.background)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            window.statusBarColor = ContextCompat.getColor(activity,android.R.color.transparent)
            window.setBackgroundDrawable(background)
        }
    }
}