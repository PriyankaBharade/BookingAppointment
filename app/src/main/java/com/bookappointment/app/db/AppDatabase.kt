package com.bookappointment.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bookappointment.app.data.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}