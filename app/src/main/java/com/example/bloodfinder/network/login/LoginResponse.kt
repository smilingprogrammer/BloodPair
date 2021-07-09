package com.example.bloodfinder.network.login

data class LoginResponse(
    val message: String,
    val token: String,
    val token_type: String,
    val user: User
)