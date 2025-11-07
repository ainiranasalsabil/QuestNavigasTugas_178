package com.example.praknavigasi.view

@Composable
fun MenuUtama(onMulaiClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Menu Utama")
    }
}