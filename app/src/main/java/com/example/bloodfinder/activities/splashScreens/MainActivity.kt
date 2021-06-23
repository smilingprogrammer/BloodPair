package com.example.bloodfinder.activities.splashScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodfinder.activities.auth.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moveToLogInScreen();
    }

    private fun moveToLogInScreen() {
        startActivity(Intent(this, SplashScreenSlideActivity::class.java));
        finish();
    }
}