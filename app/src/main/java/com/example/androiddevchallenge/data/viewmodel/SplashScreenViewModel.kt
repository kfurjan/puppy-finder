package com.example.androiddevchallenge.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.api.DogDataFetcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    dogDataFetcher: DogDataFetcher
) : ViewModel() {

    init {
        Log.d("KEVIN", "Init block")
        dogDataFetcher.fetchDogData()
        Log.d("KEVIN", "Fetching data")
    }

    fun test() {
        Log.d("KEVIN", "Test() block")
    }
}
