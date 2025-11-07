package com.example.praknavigasi.view


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(onSubmitClick: () -> Unit) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    val jenisK = listOf("Laki-laki", "Perempuan")

    Scaffold(
        topBar = { TopAppBar(title = { Text("Form Isian") }) }
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
                label = { Text("Nama Lengkap") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Jenis Kelamin:")
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
                label = { Text("Alamat") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onSubmitClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}