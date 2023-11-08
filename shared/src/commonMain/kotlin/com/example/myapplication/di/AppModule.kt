package com.example.myapplication.di

import com.example.myapplication.data.remote.ApiManager
import com.example.myapplication.data.repository.PocRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =

    startKoin {
        appDeclaration()
        modules(
            dataModule,
            platformModule()
        )
    }

val dataModule = module {
    single { ApiManager() }
    single { PocRepository(get()) }
}