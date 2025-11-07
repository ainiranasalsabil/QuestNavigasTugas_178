package com.example.praknavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praknavigasi.R

/**
 * Halaman Menu Utama aplikasi CARD-LST MOBILE APP 2025.
 * Menampilkan judul aplikasi dan tombol menuju formulir pendaftaran.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuUtama(onMulaiClick: () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.menu_title), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(context.getColor(R.color.colorAccent))
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Teks sambutan aplikasi
            Text(
                text = stringResource(R.string.welcome_text),
                fontSize = 20.sp,
                color = Color(context.getColor(R.color.colorPrimaryVariant))
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol menuju halaman formulir
            Button(
                onClick = onMulaiClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(context.getColor(R.color.colorPrimary))
                )
            ) {
                Text(stringResource(R.string.form_button), color = Color.White)
            }
        }
    }
}
