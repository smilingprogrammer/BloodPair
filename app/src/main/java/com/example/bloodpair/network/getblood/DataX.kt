package com.example.bloodpair.network.getblood

data class DataX(
    val address: String,
    val available_stock: Int,
    val blood_price: Int,
    val blood_type: String,
    val city: String,
    val email: String,
    val fullname: String,
    val id: Int,
    val phone: String,
    val state: String
)