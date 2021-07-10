package com.example.bloodfinder.activities.splashScreens

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.auth.LoginActivity
import java.lang.Boolean.getBoolean

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val appUseState = sharedPref.getBoolean(getString(R.string.app_used_state), false)

        if(!appUseState){
            val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
            with(sharedPref.edit()) {
                putBoolean(getString(R.string.app_used_state), true)
                apply()
            }
            moveToSplashScreens();
        }else {
            moveToLoginScreen()
        }


    }

    private fun moveToSplashScreens() {
        startActivity(Intent(this, SplashScreenSlideActivity::class.java));
        finish();
    }

    private fun moveToLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java));
        finish();
    }
}