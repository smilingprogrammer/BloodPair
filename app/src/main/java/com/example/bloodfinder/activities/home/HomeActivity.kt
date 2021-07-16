package com.example.bloodfinder.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bloodfinder.NavDrawerGraphDirections
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.ActivityHomeBinding
import com.example.bloodfinder.network.login.LoginResponse
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModelFactory: HomeViewModelFactory
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get user Details from intent extra and set its value in the Home activity viewModel
        var userDetails = intent.getSerializableExtra(USER_DETAILS) as LoginResponse
        viewModelFactory = HomeViewModelFactory(userDetails)

        // Setup ViewModel
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        // Setup Drawer Navigation
        drawerLayout = binding.drawer

        navView = binding.navView
        setDrawerHeadText(viewModel.userDetails.user.fullname)

        //Get navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController

        // Add Drawer to the nagivation ui
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Disable drawer in every other fragment except home
        navController.addOnDestinationChangedListener{ nc: NavController, nd: NavDestination, bd: Bundle? ->
            if (nd.id == nc.graph.startDestination){
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }else{
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        // Connect the navigation view to the NavigationUI
        NavigationUI.setupWithNavController(navView, navController)
    }

    fun setDrawerHeadText(lab: String){
        var header = navView.getHeaderView(0)
        var labname = header.findViewById<TextView>(R.id.tv_labname)
        var profile = header.findViewById<TextView>(R.id.tv_profile)

        labname.text = lab

        profile.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView2)
            navController.navigate(NavDrawerGraphDirections.actionGlobalNavigationDrawerHeader())
        }
    }

    // Override On support up navigate up to show and enable back button
    override fun onSupportNavigateUp(): Boolean {
        //Get navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    companion object{
        val USER_DETAILS = "user_details"
    }
}