package com.example.androiddevchallenge.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androiddevchallenge.BuildConfig.DB_VERSION
import com.example.androiddevchallenge.data.model.Dog

@Database(
    version = DB_VERSION,
    exportSchema = false,
    entities = [Dog::class]
)
abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}
