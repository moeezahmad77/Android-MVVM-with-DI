package com.example.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggermvvm.models.Product
import com.example.daggermvvm.models.Rating

@Database(entities = [Product::class, Rating::class], version = 1)
abstract class FakerDB: RoomDatabase() {
    abstract fun getProductDAO(): ProductDAO
}