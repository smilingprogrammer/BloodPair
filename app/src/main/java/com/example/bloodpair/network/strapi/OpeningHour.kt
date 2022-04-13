package com.example.bloodpair.network.strapi

data class OpeningHour(
    val closing_hour: String,
    val day_interval: String,
    val id: Int,
    val opening_hour: String
)