package com.example.praknavigasi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

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
        // Rute akan ditambahkan nanti
    }
}


