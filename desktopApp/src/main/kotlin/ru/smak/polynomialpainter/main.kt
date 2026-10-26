package ru.smak.polynomialpainter

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.smak.polynomialpainter.painting.CartesianPainter
import ru.smak.polynomialpainter.viewmodels.MainViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PolynomialPainter",
    ) {
        val painter = CartesianPainter()
        val vm = remember { MainViewModel() }
        App(vm, painter)
    }
}