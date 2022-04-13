package com.example.bloodpair.activities.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodpair.network.BloodHQApi
import com.example.bloodpair.network.login.LoginResponse
import com.example.bloodpair.network.registration.NewUser
import com.example.bloodpair.network.registration.RegistrationResponse
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var registerUserResponse = MutableLiveData<RegistrationResponse>()
    var apiError = MutableLiveData<String>()
    var user = MutableLiveData<LoginResponse>()
    var labs = MutableLiveData<RegistrationResponse>()

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
                    labs.value = registration.body()
                    Log.d("AUTHMODEL_RESPONSE_TEXT", "::::::::: ::::::::: :::::::: ${registration.body()} ::::::::: :::::::::::::: ::::::::::::")
                }else{
                    apiError.value = registration.message()
                    Log.d("AUTHMODEL_RESPONSE_ELSE", "::::::::: ::::::::: :::::::: $registration ::::::::: :::::::::::::: ::::::::::::")
                }
            }catch (e: Exception){
                Log.d("AUTHMODEL_CATCH", "::::::::: ::::::::: :::::::: ${e.message} ::::::::: :::::::::::::: ::::::::::::")
            }
        }
    }
}