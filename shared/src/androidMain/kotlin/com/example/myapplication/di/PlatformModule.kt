package com.example.myapplication.di

import com.example.myapplication.view_model.PocViewModel
import io.ktor.client.engine.android.Android
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single {
        Android.create()
    }

    viewModel {
        PocViewModel(get())
    }
}