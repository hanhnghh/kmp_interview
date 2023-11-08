package com.example.myapplication.android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.android.screens.HomeScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MainNavigationHost(
    navController: NavHostController,
    onExitApp: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.HOME,
    ) {

        composable(MainRoute.HOME) {
            HomeScreen()
        }

    }

}

object MainRoute {
    const val HOME = "home"
}