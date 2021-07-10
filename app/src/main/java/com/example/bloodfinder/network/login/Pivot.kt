package com.example.bloodfinder.network.login

import java.io.Serializable

data class Pivot(
    val role_id: Int,
    val user_id: Int,
    val user_type: String
): Serializable