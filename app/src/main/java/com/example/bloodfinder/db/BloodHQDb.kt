package com.example.bloodfinder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bloodfinder.db.dao.entities.UserDataDao
import com.example.bloodfinder.db.entities.UserData
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = arrayOf(UserData::class), version = 1)
abstract class BloodHQDb : RoomDatabase(){
    abstract fun userDataDao(): UserDataDao

    companion object{

        operator fun invoke(context: Context): BloodHQDb{
            val INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                BloodHQDb::class.java,"user_data")
                .fallbackToDestructiveMigration().build()
            return INSTANCE
        }
    }
}