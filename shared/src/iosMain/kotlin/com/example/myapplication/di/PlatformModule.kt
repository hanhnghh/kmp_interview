package com.example.myapplication.di

import com.example.myapplication.view_model.PocViewModel
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single {
        Darwin.create()
    }

    factory {
        PocViewModel(get())
    }
}