package com.example.daggermvvm.di

import android.content.Context
import androidx.room.Room
import com.example.daggermvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideProductDB(@ApplicationContext context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "fakerdb").build()
    }
}