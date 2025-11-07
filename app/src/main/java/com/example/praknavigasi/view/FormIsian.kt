package com.example.praknavigasi.view

@Composable
fun FormIsian(onSubmitClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Form Isian")
    }
}