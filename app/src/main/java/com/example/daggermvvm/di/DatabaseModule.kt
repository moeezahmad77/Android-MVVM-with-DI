package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import com.example.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideProductDB(context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "fakerdb").build()
    }
}