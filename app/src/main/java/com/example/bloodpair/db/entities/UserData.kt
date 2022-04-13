package com.example.bloodpair.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val Id: Long = 0,

    @ColumnInfo(name = "userId")
    val userId: Int,

    @ColumnInfo(name = "fullname")
    val fullname: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "state")
    val state: String,

    @ColumnInfo(name = "token")
    val token: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "email")
    val email: String,
)
