package com.example.androiddevchallenge.data.api

import android.content.Context
import android.util.Log
import com.example.androiddevchallenge.data.api.model.Dog
import com.example.androiddevchallenge.data.repository.DogRepository
import com.example.androiddevchallenge.util.downloadImageAndStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DogDataFetcher @Inject constructor(
    @ApplicationContext private val context: Context,
    private val dogRepository: DogRepository,
    private val dogApi: DogApi
) {
    private val dataFetcherScope = CoroutineScope(Dispatchers.IO)

    fun fetchDogData() {
        val request = dogApi.fetchDogs()
        Log.d("KEVIN", "Tu?")
        request.enqueue(
            object : Callback<List<Dog>> {
                override fun onResponse(
                    call: Call<List<Dog>>,
                    response: Response<List<Dog>>
                ) {
                    if (response.body() != null) {
                        populateDatabase(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                    Log.d(javaClass.name, t.message, t)
                }
            }
        )
    }

    private fun populateDatabase(dogs: List<Dog>) {
        dataFetcherScope.launch {
            dogs.forEach {
                val picturePath = downloadImageAndStore(
                    context,
                    it.pictureUrl,
                    it.breeds[0].name.replace(" ", "_")
                )
                dogRepository.insert(
                    com.example.androiddevchallenge.data.model.Dog(
                        null,
                        it.breeds[0].name,
                        it.breeds[0].bredFor,
                        it.breeds[0].breedGroup,
                        it.breeds[0].lifeSpan,
                        it.breeds[0].temperament,
                        picturePath ?: "",
                        it.pictureWidth,
                        it.pictureHeight,
                        it.breeds[0].weight.metric,
                        it.breeds[0].height.metric
                    )
                )
            }
        }
    }
}
