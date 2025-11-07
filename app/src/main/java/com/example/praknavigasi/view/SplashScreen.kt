package com.example.praknavigasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.praknavigasi.R
import com.example.praknavigasi.navigation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.splash_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1565C0),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 32.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = stringResource(R.string.splash_subtitle),
                modifier = Modifier
                    .size(250.dp)
                    .padding(vertical = 16.dp)
            )

            Text(
                text = "${stringResource(R.string.splash_name)}\n${stringResource(R.string.splash_nim)}",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

        Button(
            onClick = {
                navController.navigate(Screen.Menu.name) {
                    popUpTo(Screen.Splash.name) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.colorPrimaryVariant)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 9.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
        ) {
            Text(
                text = stringResource(R.string.splash_button),
                color = colorResource(R.color.colorOnPrimary),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
