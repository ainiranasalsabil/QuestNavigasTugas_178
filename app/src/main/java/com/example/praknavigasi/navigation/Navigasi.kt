package com.example.praknavigasi.navigation

package com.example.navigasi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Screen {
    Splash,
    Menu,
    Form,
    PopUp
}

@Composable
fun Navigasi(navController: NavHostController = rememberNavController()) {
    // Akan diisi dengan NavHost nanti
}

