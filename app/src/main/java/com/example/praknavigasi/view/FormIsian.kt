package com.example.praknavigasi.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.praknavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(onSubmitClick: () -> Unit) {
    val context = LocalContext.current
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    val jenisK = listOf("Laki-laki", "Perempuan")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.form_title), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(context.getColor(R.color.colorAccent))
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(R.string.nama_lengkap)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(R.string.jenis_kelamin))
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

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(stringResource(R.string.alamat)) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onSubmitClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(context.getColor(R.color.colorPrimary))
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.submit), color = Color.White)
            }
        }
    }
}
