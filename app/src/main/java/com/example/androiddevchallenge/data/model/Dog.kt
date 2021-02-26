package com.example.androiddevchallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_table")
data class Dog(
    @PrimaryKey(autoGenerate = true) val _id: Long?,
    @ColumnInfo(name = "breedName") val breedName: String,
    @ColumnInfo(name = "bredFor") val bredFor: String,
    @ColumnInfo(name = "breedGroup") val breedGroup: String,
    @ColumnInfo(name = "lifeSpan") val lifeSpan: String,
    @ColumnInfo(name = "temperament") val temperament: String,
    @ColumnInfo(name = "picturePath") val picturePath: String,
    @ColumnInfo(name = "pictureWidth") val pictureWidth: Int,
    @ColumnInfo(name = "pictureHeight") val pictureHeight: Int,
    @ColumnInfo(name = "dogWeight") val dogWeight: String,
    @ColumnInfo(name = "dogHeight") val dogHeight: String
)
