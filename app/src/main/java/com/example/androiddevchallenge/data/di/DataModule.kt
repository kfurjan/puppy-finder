package com.example.androiddevchallenge.data.di

import android.content.Context
import com.example.androiddevchallenge.BuildConfig
import com.example.androiddevchallenge.data.api.DogApi
import com.example.androiddevchallenge.data.api.DogDataFetcher
import com.example.androiddevchallenge.data.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DataModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun providesRetrofit(BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideDogApi(retrofit: Retrofit): DogApi =
        retrofit.create(DogApi::class.java)

    @Provides
    @Singleton
    fun provideDogDataFetcher(
        @ApplicationContext context: Context,
        dogRepository: DogRepository,
        dogApi: DogApi,
    ) = DogDataFetcher(
        context,
        dogRepository,
        dogApi
    )
}
