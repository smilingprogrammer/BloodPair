package com.example.bloodfinder.network

import com.example.bloodfinder.network.login.LoginResponse
import com.example.bloodfinder.network.registration.NewUser
import com.example.bloodfinder.network.registration.RegistrationResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private val baseUrl = "https://bloodhq-be.herokuapp.com/api/v1/"

interface BloodHQApi {

    // Log in user
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @FieldMap params: HashMap<String?, String?>
    ): Response<LoginResponse>

    // Register User
    @POST("register")
    suspend fun registerUser(@Body newUser: NewUser): Response<RegistrationResponse>

    // Companion object to automatically invoke BloodHQAPI connection when class is called
    companion object {
        operator fun invoke(): BloodHQApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(BloodHQApi::class.java)
        }
    }
}