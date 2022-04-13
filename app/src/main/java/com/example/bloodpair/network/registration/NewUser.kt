package com.example.bloodpair.network.registration

data class NewUser(
    val fullname: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
    val phone: Long,
    val address: String,
    val city: String,
    val state: String,
)
