package com.example.bloodpair.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bloodpair.db.entities.UserData

@Dao
interface UserDataDao {

    @Query("SELECT * FROM user_data WHERE token=:token")
    fun findUser(token: String): UserData

    @Insert
    fun insertUser(vararg user: UserData)
}