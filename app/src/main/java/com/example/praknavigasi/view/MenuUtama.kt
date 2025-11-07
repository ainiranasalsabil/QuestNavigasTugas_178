package com.example.praknavigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.praknavigasi.R
import com.example.praknavigasi.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuUtama(navController: NavController) {
    val pesertaList = listOf(
        mapOf(
            "nama" to "Aini Rana Salsabil",
            "gender" to "Perempuan",
            "status" to "Belum Kawin",
            "alamat" to "Jakarta"
        ),
        mapOf(
            "nama" to "Budi Santoso",
            "gender" to "Laki-laki",
            "status" to "Sudah Kawin",
            "alamat" to "Bandung"
        )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.menu_list_title), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF64B5F6))
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // --- Body: List peserta dalam Box ---
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    pesertaList.forEachIndexed { index, peserta ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (index % 2 == 0) Color(0xFFBBDEFB) else Color(0xFFC8E6C9)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                Text("Nama: ${peserta["nama"]}", fontSize = 16.sp, color = Color.Black)
                                Text("Jenis Kelamin: ${peserta["gender"]}", fontSize = 16.sp, color = Color.Black)
                                Text("Status: ${peserta["status"]}", fontSize = 16.sp, color = Color.Black)
                                Text("Alamat: ${peserta["alamat"]}", fontSize = 16.sp, color = Color.Black)
                            }
                        }
                    }
                }

                // --- Buttons: Beranda & Formulir ---
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.Splash.name) {
                                popUpTo(Screen.Splash.name) { inclusive = true }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.back), color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = { navController.navigate(Screen.Form.name) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(stringResource(R.string.menu_form_button), color = Color.White)
                    }
                }
            }
        }
    )
}
