package com.example.praknavigasi.view

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(context.getColor(R.color.colorAccent))),
        contentAlignment = Alignment.Center
    )