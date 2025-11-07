package com.example.praknavigasi.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi.view.SplashScreen
import com.example.navigasi.view.MenuUtama

enum class Screen {
    Splash,
    Menu,
    Form,
    PopUp
}

@Composable
fun Navigasi(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.name
    ) {
        composable(Screen.Splash.name) {
            SplashScreen {
                navController.navigate(Screen.Menu.name)
            }
        }
    }
}

