package com.example.bloodfinder.network.login

import java.io.Serializable

data class LoginResponse(
    val message: String,
    val token: String,
    val token_type: String,
    val user: User
): Serializable