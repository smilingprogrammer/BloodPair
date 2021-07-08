package com.example.bloodfinder.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BloodHQApi {

    @GET("lab")
    suspend fun getLabs(): Response<String>

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