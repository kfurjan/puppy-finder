package com.example.androiddevchallenge.data.di

import com.example.androiddevchallenge.data.dao.DogDao
import com.example.androiddevchallenge.data.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDogRepository(dogDao: DogDao) = DogRepository(dogDao)
}
