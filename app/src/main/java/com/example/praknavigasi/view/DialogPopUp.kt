package com.example.praknavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogPopUp(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Data Terkirim") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Data berhasil dikirim!")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBackClick) {
                Text("Kembali ke Menu")
            }
        }
    }
}