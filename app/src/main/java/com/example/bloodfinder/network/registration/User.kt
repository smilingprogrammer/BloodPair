package com.example.bloodfinder.network.registration

data class User(
    val address: String,
    val city: String,
    val email: String,
    val fullname: String,
    val id: Int,
    val phone: String,
    val state: String
)