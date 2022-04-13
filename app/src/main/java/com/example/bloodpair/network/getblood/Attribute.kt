package com.example.bloodpair.network.getblood

data class Attribute(
    val address: String,
    val available_stock: String,
    val blood_price: String,
    val blood_type: String,
    val city: String,
    val email: String,
    val lab_name: String,
    val phone: String,
    val state: String
)