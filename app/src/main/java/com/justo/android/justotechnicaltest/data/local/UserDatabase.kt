package com.justo.android.justotechnicaltest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.justo.android.justotechnicaltest.data.local.dao.UserDao
import com.justo.android.justotechnicaltest.domain.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}