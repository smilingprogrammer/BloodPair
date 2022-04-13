package com.example.bloodpair.network

import com.example.bloodpair.network.getblood.Bloods
import com.example.bloodpair.network.login.LoginResponse
import com.example.bloodpair.network.registration.NewUser
import com.example.bloodpair.network.registration.RegistrationResponse
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

    @GET("bloods")
    suspend fun getAllAvailableBloods(): Response<Bloods>

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