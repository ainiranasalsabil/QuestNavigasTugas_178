package com.example.praknavigasi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praknavigasi.view.*

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
        // Splash → Menu
        composable(Screen.Splash.name) {
            SplashScreen {
                navController.navigate(Screen.Menu.name)
            }
        }

        // Menu → Form
        composable(Screen.Menu.name) {
            MenuUtama {
                navController.navigate(Screen.Form.name)
            }
        }

        // Form → PopUp
        composable(Screen.Form.name) {
            FormIsian {
                navController.navigate(Screen.PopUp.name)
            }
        }

        // PopUp → kembali ke Menu
        composable(Screen.PopUp.name) {
            DialogPopUp {
                navController.popBackStack(Screen.Menu.name, inclusive = false)
            }
        }
    }
}
