package com.example.androiddevchallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    @SerialName("id")
    val idBreed: Int,
    @SerialName("bred_for")
    val bredFor: String,
    @SerialName("breed_group")
    val breedGroup: String,
    @SerialName("life_span")
    val lifeSpan: String,
    @SerialName("name")
    val name: String,
    @SerialName("reference_image_id")
    val referenceImageId: String,
    @SerialName("temperament")
    val temperament: String,
    @SerialName("height")
    val height: Height,
    @SerialName("weight")
    val weight: Weight
)
