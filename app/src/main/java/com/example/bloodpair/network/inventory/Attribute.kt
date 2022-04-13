package com.example.bloodpair.network.inventory

data class Attribute(
    val available_stock: String,
    val blood_id: Int,
    val blood_price: String,
    val blood_type: String,
    val created_at: String,
    val total_sold_stock: String,
    val updated_at: String
)