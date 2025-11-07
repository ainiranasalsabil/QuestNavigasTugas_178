package com.example.praknavigasi.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuUtama(onMulaiClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu Utama") }
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
            Text(text = "CARD-LST MOBILE APP 2025")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onMulaiClick) {
                Text(text = "Formulir Pendaftaran")
            }
        }
    }
}