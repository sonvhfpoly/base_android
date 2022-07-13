package com.vnextglobal.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vnextglobal.core.model.User

@Database(entities = [User::class], version = 1)
internal abstract class BaseDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}