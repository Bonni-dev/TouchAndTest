package com.example.touchandtest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.touchandtest.presentation.view.HomeView
import com.example.touchandtest.presentation.view.ScreenTestView

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN ){

        composable(Routes.HOME_SCREEN) {
            HomeView(navController)
        }

        composable(Routes.TOUCH_TEST_SCREEN) {
            ScreenTestView(navController)
        }
    }
}
