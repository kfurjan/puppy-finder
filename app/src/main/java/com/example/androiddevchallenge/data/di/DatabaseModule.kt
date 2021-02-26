package com.example.androiddevchallenge.data.di

import android.content.Context
import androidx.room.Room
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.dao.DogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            DogDatabase::class.java,
            context.getString(R.string.dog_d)
        ).build()

    @Provides
    @Singleton
    fun provideDriverDao(dogDatabase: DogDatabase) = dogDatabase.dogDao()
}