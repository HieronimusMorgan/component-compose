package com.morg.component.login.screen

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
}

data class User(val username: String, val password: String)