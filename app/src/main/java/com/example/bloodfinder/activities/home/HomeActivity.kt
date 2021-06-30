package com.example.bloodfinder.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Drawer Navigation
        drawerLayout = binding.drawer
        //Get navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        // Add Drawer to the nagivation ui
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        // Connect the navigation view to the NavigationUI
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // Override On support up navigate up to show and enable back button
    override fun onSupportNavigateUp(): Boolean {
        //Get navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}