package com.example.androiddevchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("id")
    val idDog: String,
    @SerialName("breeds")
    val breeds: List<Breed>,
    @SerialName("url")
    val pictureUrl: String,
    @SerialName("height")
    val pictureHeight: Int,
    @SerialName("width")
    val pictureWidth: Int
)
