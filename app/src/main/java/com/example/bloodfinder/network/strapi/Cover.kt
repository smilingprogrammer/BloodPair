package com.example.bloodfinder.network.strapi

data class Cover(
    val created_at: String,
    val ext: String,
    val hash: String,
    val id: Int,
    val mime: String,
    val name: String,
    val provider: String,
    val provider_metadata: Any,
    val sha256: String,
    val size: Double,
    val updated_at: String,
    val url: String
)