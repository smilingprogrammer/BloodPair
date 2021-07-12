package com.example.bloodfinder.network.strapi

data class Labs(
    val content: List<Content>,
    val cover: Cover,
    val id: Int,
    val opening_hours: List<OpeningHour>,
    val title: String
)