package com.example.bloodfinder.network

import com.example.bloodfinder.network.login.LoginResponse
import com.example.bloodfinder.network.registration.RegistrationResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface BloodHQApi {

    // Log in user
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @FieldMap params: HashMap<String?, String?>
    ): Response<LoginResponse>

    // Register User
    @FormUrlEncoded
    @POST("register")
    suspend fun registerUser(
        @FieldMap params: HashMap<String?, String?>
    ): Response<RegistrationResponse>

    // Companion object to automatically invoke BloodHQAou connection when class is called
    companion object {
        operator fun invoke(): BloodHQApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://bloodhq-be.herokuapp.com/api/v1/")
                .build()
                .create(BloodHQApi::class.java)
        }
    }
}