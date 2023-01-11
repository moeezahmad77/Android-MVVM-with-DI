package com.example.daggermvvm.models

import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithRatings(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "id",
        entityColumn = "prodId"
    )
    val rating: Rating
)
