package ru.smak.polynomialpainter.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextPainter.paint
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import ru.smak.polynomialpainter.painting.CartesianPainter
import ru.smak.polynomialpainter.painting.Painter
import java.awt.image.BufferedImage

class MainViewModel : ViewModel() {
    var canvasSize by mutableStateOf(IntSize.Zero)
    private val painter: Painter = CartesianPainter()
    fun render(): BufferedImage{
        return painter.paint(canvasSize.width, canvasSize.height)
    }
}