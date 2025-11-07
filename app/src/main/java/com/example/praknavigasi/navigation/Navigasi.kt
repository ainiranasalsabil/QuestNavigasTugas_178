package com.example.praknavigasi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praknavigasi.view.*

enum class Screen {
    Splash,
    Form,
    Menu
}

@Composable
fun Navigasi() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.name
    ) {
        // Halaman SplashScreen
        composable(Screen.Splash.name) {
            SplashScreen(navController)
        }

        // Halaman FormIsian
        composable(Screen.Form.name) {
            FormIsian(navController = navController)
        }

        // Halaman MenuUtama
        composable(Screen.Menu.name) {
            MenuUtama(navController = navController)
        }
    }
}
