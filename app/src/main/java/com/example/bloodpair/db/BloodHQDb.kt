package com.example.bloodpair.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bloodpair.db.dao.UserDataDao
import com.example.bloodpair.db.entities.UserData

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