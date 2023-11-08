package com.example.myapplication.android

import android.app.Application
import com.example.myapplication.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MainApplication: Application()  {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MainApplication)
            androidLogger(Level.ERROR)
        }
    }
}