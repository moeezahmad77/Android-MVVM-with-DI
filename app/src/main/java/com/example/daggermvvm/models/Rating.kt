package com.example.daggermvvm.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = Product::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("prodId"),
    onDelete = CASCADE
)]
)
data class Rating(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val prodId: Int,
    val count: Int,
    val rate: Double
)