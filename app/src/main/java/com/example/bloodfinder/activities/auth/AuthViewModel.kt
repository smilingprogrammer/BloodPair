package com.example.bloodfinder.activities.auth

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodfinder.activities.splashScreens.SplashScreenSlideActivity
import com.example.bloodfinder.db.BloodHQDb
import com.example.bloodfinder.db.BloodHQRepository
import com.example.bloodfinder.db.entities.UserData
import com.example.bloodfinder.network.BloodHQApi
import com.example.bloodfinder.network.login.LoginResponse
import com.example.bloodfinder.network.registration.NewUser
import com.example.bloodfinder.network.registration.RegistrationResponse
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var registerUserResponse = MutableLiveData<RegistrationResponse>()
    var apiError = MutableLiveData<String>()
    var user = MutableLiveData<LoginResponse>()

    fun loginUser(email: String, password: String){
        viewModelScope.launch {
            val params = HashMap<String?, String?>()
            params["email"] = email
            params["password"] = password

            var userLogin = BloodHQApi().loginUser(params)

            if(userLogin.isSuccessful){
                user.value = userLogin.body()
            }else{
                apiError.value = userLogin.message()
                Log.d("LOGIN_USER", "------------------- $userLogin ---------------------------")
            }
        }
    }

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            var registration = BloodHQApi().registerUser(newUser)

            try {
                if(registration.isSuccessful){
                    registerUserResponse.value = registration.body()
                    Log.d("AUTHMODEL_RESPONSE_TEXT", "::::::::: ::::::::: :::::::: ${registration.body()} ::::::::: :::::::::::::: ::::::::::::")
                }else{
                    apiError.value = registration.message()
                    Log.d("AUTHMODEL_RESPONSE_TEXT", "::::::::: ::::::::: :::::::: $registration ::::::::: :::::::::::::: ::::::::::::")
                }
            }catch (e: Exception){
                Log.d("AUTHMODEL_RESPONSE_TEXT", "::::::::: ::::::::: :::::::: ${e.message} ::::::::: :::::::::::::: ::::::::::::")
            }
        }
    }
}