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
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Selamat datang di aplikasi")
        }
    }
}