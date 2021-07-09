package com.example.bloodfinder.activities.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodfinder.network.BloodHQApi
import com.example.bloodfinder.network.registration.NewUser
import com.example.bloodfinder.network.registration.RegistrationResponse
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var registerUserResponse = MutableLiveData<RegistrationResponse>()
    var apiError = MutableLiveData<String>()

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            var registration = BloodHQApi().registerUser(
                newUser.fullname,
                newUser.email,
                newUser.password,
                newUser.password_confirmation,
                newUser.phone,
                newUser.address,
                newUser.city,
                newUser.state
            )

            if(registration.isSuccessful){
                registerUserResponse.value = registration.body()
            }else{
                apiError.value = registration.message()
                Log.d("AUTHMODEL_RESPONSE_TEXT", "${registration.message()}")
            }
        }
    }
}