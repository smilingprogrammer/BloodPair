package com.example.bloodpair.network.login

import java.io.Serializable

data class User(
    val address: String,
    val city: String,
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val fullname: String,
    val id: Int,
    val phone: String,
    val roles: List<Role>,
    val state: String,
    val updated_at: String
): Serializable