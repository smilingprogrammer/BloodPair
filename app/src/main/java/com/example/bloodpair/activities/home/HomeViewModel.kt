package com.example.bloodpair.activities.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodpair.network.BloodHQApi
import com.example.bloodpair.network.getblood.Bloods
import com.example.bloodpair.network.getblood.Data
import com.example.bloodpair.network.login.LoginResponse
import kotlinx.coroutines.launch

class HomeViewModel(var userDetails: LoginResponse): ViewModel() {
    private lateinit var getBloods: Bloods
    var bloods = MutableLiveData<List<Data>>()
    var apiError = MutableLiveData<String>()

    fun getAllAvailableBloods(){
        viewModelScope.launch {
            var getBloods = BloodHQApi().getAllAvailableBloods()

            try {
                if(getBloods.isSuccessful){
                    var bloodsObj = getBloods.body()
                    Log.d("GET BLOODS EXCEPTION", ":::::::::: :::::: :::::: ${getBloods.body()!!.data[0]} ::::::::::: :::::::::: ::::::::")

                    bloods.value = bloodsObj?.data
                }else{
                    apiError.value = "Connection to blood api error...."
                }
            }catch (e:Exception){
                Log.d("GET BLOODS EXCEPTION", "$e")
            }
        }
    }
}