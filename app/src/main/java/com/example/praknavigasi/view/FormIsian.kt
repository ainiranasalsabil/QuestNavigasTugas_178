package com.example.praknavigasi.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(onSubmitClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Form Isian") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Isi data anda di bawah ini.")
        }
    }
}