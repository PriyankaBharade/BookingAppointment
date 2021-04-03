package com.bookappointment.app.helper

import com.bookappointment.app.data.User

interface DatabaseHelper {
    suspend fun getUsers(): List<User>
    suspend fun insertAll(users: List<User>)
    suspend fun delete(users: User)
    suspend fun isRowIsExist(email: String) : Boolean

}