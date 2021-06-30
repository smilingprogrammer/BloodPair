package com.example.bloodfinder.activities.splashScreens

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.ActivitySplashScreenSlideBinding

class SplashScreenSlideActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenSlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenSlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    fun setData(){
        val images = arrayListOf(R.drawable.bloodhq, R.drawable.redbloodcells, R.drawable.image24)
        binding.splashScreens.adapter = SplashScreenViewPagerAdapter(images)
        binding.circles.setViewPager(binding.splashScreens)
    }
}