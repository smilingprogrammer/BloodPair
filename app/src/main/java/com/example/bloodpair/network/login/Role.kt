package com.example.bloodpair.network.login

import java.io.Serializable

data class Role(
    val created_at: String,
    val description: Any,
    val display_name: String,
    val id: Int,
    val name: String,
    val pivot: Pivot,
    val updated_at: String
): Serializable