package com.example.bloodfinder.activities.splashScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bloodfinder.databinding.ActivitySplashScreenSlideBinding

class SplashScreenSlideActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenSlideBinding
    private var textList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenSlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListText()
        setData(textList)
    }

    private fun addListText (){
        textList.add("WELCOME")
        textList.add("TO BLOOD FINDER")
        textList.add("LETS GET STARTED")
    }

    fun setData(textlist: MutableList<String>){
        Log.d("SPLASH ACTIVITY","TEXT LIST HAS ${textlist.size} ITEMS IN IT --------------------------------------")
        binding.splashScreens.adapter = SplashScreenViewPagerAdapter(textlist)
        binding.circles.setViewPager(binding.splashScreens)
    }
}