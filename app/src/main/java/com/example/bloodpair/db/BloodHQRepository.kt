package com.example.bloodpair.db

import android.content.Context
import android.util.Log
import com.example.bloodpair.db.entities.UserData

class BloodHQRepository(context: Context) {

    private val db = BloodHQDb(context)

    fun findUser(token: String): UserData {
        var user = db.userDataDao().findUser(token)
        return user
    }

    suspend fun insertUser(user: UserData) {
        Log.d("USER ADDED TO ROOM", "----- SUCCESS ---- ${user.fullname}------")
        db.userDataDao().insertUser(user)
    }
}