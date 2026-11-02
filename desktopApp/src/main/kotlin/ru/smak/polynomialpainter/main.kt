package ru.smak.polynomialpainter

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.smak.polynomialpainter.painting.CartesianPainter
import ru.smak.polynomialpainter.painting.FunctionPainter
import ru.smak.polynomialpainter.viewmodels.MainViewModel
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PolynomialPainter",
    ) {
        val vm = remember { MainViewModel() }
        App(
            vm,
            CartesianPainter(),
            FunctionPainter(::sin, Color.Green),
            FunctionPainter(::cos, Color.Red),
            FunctionPainter({x -> x * x}, Color.Magenta),
        )
    }
}