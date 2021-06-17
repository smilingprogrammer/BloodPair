package com.example.bloodfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moveToLogInScreen();
    }

    private fun moveToLogInScreen() {
        startActivity(Intent(this, LoginActivity::class.java));
        finish();
    }
}