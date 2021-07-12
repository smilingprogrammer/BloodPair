package com.example.bloodfinder.activities.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bloodfinder.db.BloodHQRepository
import com.example.bloodfinder.db.entities.UserData
import com.example.bloodfinder.network.login.LoginResponse
import com.example.bloodfinder.network.login.Pivot
import com.example.bloodfinder.network.login.Role
import com.example.bloodfinder.network.login.User

class HomeViewModel(var userDetails: LoginResponse): ViewModel() {
    init {
        Log.d("HOME VIEW MODEL", "------------- User is logged in :::  ${userDetails.user.fullname} ::: ------------------")
    }
}