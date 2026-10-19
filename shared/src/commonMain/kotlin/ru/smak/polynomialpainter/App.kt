package ru.smak.polynomialpainter

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import ru.smak.polynomialpainter.painting.Painter
import ru.smak.polynomialpainter.viewmodels.MainViewModel

@Composable
fun App(
    vm: MainViewModel,
    painter: Painter,
) {

    MaterialTheme {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .onSizeChanged { vm.onCanvasSizeChange(it) }
        ) {
            with(painter) { paint() }
        }
    }
}