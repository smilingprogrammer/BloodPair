package com.example.bloodfinder.activities.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bloodfinder.db.BloodHQRepository
import com.example.bloodfinder.db.entities.UserData
import com.example.bloodfinder.network.login.LoginResponse
import com.example.bloodfinder.network.login.Pivot
import com.example.bloodfinder.network.login.Role
import com.example.bloodfinder.network.login.User

class HomeViewModel: ViewModel() {

    var userDetails = MutableLiveData<LoginResponse>()
}