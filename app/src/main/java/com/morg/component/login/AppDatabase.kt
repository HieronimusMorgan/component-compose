package com.morg.component.login

import androidx.room.Database
import androidx.room.RoomDatabase
import com.morg.component.login.screen.User
import com.morg.component.login.screen.UserDao

// Entities: Add all entities (tables) here
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Define DAOs
    abstract fun userDao(): UserDao
}
