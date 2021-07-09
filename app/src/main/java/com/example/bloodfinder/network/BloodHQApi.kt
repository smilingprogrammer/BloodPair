package com.example.bloodfinder.network

import com.example.bloodfinder.network.registration.RegistrationResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BloodHQApi {

    @FormUrlEncoded
    @POST("register")
    suspend fun registerUser(
        @Field("fullname") fullname: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String,
        @Field("phone") phone: String,
        @Field("address") address: String,
        @Field("city") city: String,
        @Field("state") state: String,
    ): Response<RegistrationResponse>



    companion object {
        operator fun invoke(): BloodHQApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://bloodhq-be.herokuapp.com/api/v1")
                .build()
                .create(BloodHQApi::class.java)
        }
    }
}