package com.bookappointment.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bookappointment.app.data.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Query("SELECT EXISTS(SELECT * FROM User WHERE email = :email)")
    fun isRowIsExist(email: String): Boolean

    @Insert
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun delete(user: User)
}