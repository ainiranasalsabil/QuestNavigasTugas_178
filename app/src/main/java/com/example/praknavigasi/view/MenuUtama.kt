package com.example.praknavigasi.view

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
            Text(
                text = stringResource(R.string.welcome_text),
                fontSize = 20.sp,
                color = Color(context.getColor(R.color.colorPrimaryVariant))
            )
            Spacer(modifier = Modifier.height(24.dp))
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