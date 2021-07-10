package com.example.bloodfinder.activities.home

import androidx.lifecycle.ViewModel
import com.example.bloodfinder.db.BloodHQRepository
import com.example.bloodfinder.db.entities.UserData

class HomeViewModel: ViewModel() {

    private lateinit var userDataRoom: UserData
    private lateinit var userRepo: BloodHQRepository

}