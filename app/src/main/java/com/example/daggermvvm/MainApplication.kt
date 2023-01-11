package com.example.daggermvvm

import android.app.Application
import com.example.daggermvvm.di.ApplicationComponent
import com.example.daggermvvm.di.DaggerApplicationComponent

class MainApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}