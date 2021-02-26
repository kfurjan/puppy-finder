package com.example.androiddevchallenge.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.androiddevchallenge.data.model.Dog
import kotlinx.coroutines.flow.Flow

@Dao
abstract class DogDao : BaseDao<Dog> {

    @Query("SELECT * FROM dogs_table")
    abstract fun query(): Flow<List<Dog>>
}
