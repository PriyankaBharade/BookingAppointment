package com.bookappointment.app.helper

import com.bookappointment.app.data.User
import com.bookappointment.app.db.AppDatabase

class DatabaseHelperImpl(private val appDatabase: AppDatabase) :
    DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun delete(users: User) = appDatabase.userDao().delete(users)

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

    override suspend fun isRowIsExist(email: String) = appDatabase.userDao().isRowIsExist(email)

}