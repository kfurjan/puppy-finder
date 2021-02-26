package com.example.androiddevchallenge.data.api

import com.example.androiddevchallenge.BuildConfig.API_LIMIT
import com.example.androiddevchallenge.BuildConfig.DOG_API_KEY
import com.example.androiddevchallenge.BuildConfig.PICTURE_SIZE
import com.example.androiddevchallenge.data.api.model.Dog
import retrofit2.Call
import retrofit2.http.GET

interface DogApi {
    @GET("?limit=$API_LIMIT&size=$PICTURE_SIZE&has_breeds=true&order=RANDOM&$DOG_API_KEY")
    fun fetchDogs(): Call<List<Dog>>
}
