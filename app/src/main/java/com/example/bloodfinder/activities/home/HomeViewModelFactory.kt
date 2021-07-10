package com.example.bloodfinder.activities.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bloodfinder.network.login.LoginResponse

class HomeViewModelFactory(private val userDetails: LoginResponse): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(userDetails) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}