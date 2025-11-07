package com.example.praknavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(navController: NavController) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val jenisK = listOf(
        "Laki-laki",
        "Perempuan"
    )
    val statusList = listOf(
        "Lajang",
        "Janda",
        "Duda"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulir Pendaftaran", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF64B5F6))
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                )  {

                    // Card untuk Nama
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        OutlinedTextField(
                            value = nama,
                            onValueChange = { nama = it },
                            label = { Text("Nama Lengkap") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Card untuk Jenis Kelamin
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E6C9)),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Jenis Kelamin", fontSize = 16.sp)
                            Row(modifier = Modifier.padding(top = 8.dp)) {
                                jenisK.forEach { item ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 16.dp)
                                    ) {
                                        RadioButton(
                                            selected = selectedGender == item,
                                            onClick = { selectedGender = item }
                                        )
                                        Text(text = item)
                                    }
                                }
                            }
                        }
                    }

                    // Card untuk Status Perkawinan
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4)),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Status Perkawinan", fontSize = 16.sp)
                            Row(modifier = Modifier.padding(top = 8.dp)) {
                                statusList.forEach { item ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(end = 16.dp)
                                    ) {
                                        RadioButton(
                                            selected = selectedStatus == item,
                                            onClick = { selectedStatus = item }
                                        )
                                        Text(text = item)
                                    }
                                }
                            }
                        }
                    }

                    // Card untuk Alamat
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFCCBC)),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        OutlinedTextField(
                            value = alamat,
                            onValueChange = { alamat = it },
                            label = { Text("Alamat") },
                            singleLine = false,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        )
                    }
                }

                // Tombol Back & Submit
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text("Beranda", color = Color.White, fontSize = 16.sp)
                    }

                    Button(
                        onClick = {
                            if (nama.isNotEmpty() && selectedGender.isNotEmpty() &&
                                selectedStatus.isNotEmpty() && alamat.isNotEmpty()
                            ) {
                                showDialog = true
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF64B5F6)),
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text("Submit", color = Color.White, fontSize = 16.sp)
                    }
                }

                // Popup Dialog
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            TextButton(onClick = {
                                showDialog = false
                                nama = ""
                                alamat = ""
                                selectedGender = ""
                                selectedStatus = ""
                            }) {
                                Text("OK")
                            }
                        },
                        title = { Text("Konfirmasi Data") },
                        text = {
                            Column {
                                Text("Nama: $nama")
                                Text("Jenis Kelamin: $selectedGender")
                                Text("Status: $selectedStatus")
                                Text("Alamat: $alamat")
                            }
                        },
                        containerColor = Color.White
                    )
                }
            }
        }
    )
}
