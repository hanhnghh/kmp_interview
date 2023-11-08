package com.example.myapplication.view_model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual abstract class ViewModel  actual constructor(){

    actual val viewModelScope: CoroutineScope
        get() = MainScope()

    protected actual open fun onCleared(){

    }
}