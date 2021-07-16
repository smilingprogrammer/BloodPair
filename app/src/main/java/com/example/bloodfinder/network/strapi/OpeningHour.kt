package com.example.bloodfinder.network.strapi

data class OpeningHour(
    val closing_hour: String,
    val day_interval: String,
    val id: Int,
    val opening_hour: String
)