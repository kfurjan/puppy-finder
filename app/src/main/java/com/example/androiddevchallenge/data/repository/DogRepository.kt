package com.example.androiddevchallenge.data.repository

import com.example.androiddevchallenge.data.dao.DogDao
import com.example.androiddevchallenge.data.model.Dog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogRepository @Inject constructor(private val dogDao: DogDao) {

    fun queryAll(): Flow<List<Dog>> = dogDao.query()

    suspend fun insert(dog: Dog) = dogDao.insert(dog)

    suspend fun update(dog: Dog) = dogDao.update(dog)
}
