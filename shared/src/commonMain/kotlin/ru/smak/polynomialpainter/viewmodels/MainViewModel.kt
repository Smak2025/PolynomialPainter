package ru.smak.polynomialpainter.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import ru.smak.polynomialpainter.painting.Painter
import java.awt.image.BufferedImage

class MainViewModel(private val painter: Painter) : ViewModel() {
    var canvasSize by mutableStateOf(IntSize.Zero)

    var bitmap: ImageBitmap? by mutableStateOf(null)
        private set

    fun onCanvasSizeChange(size: IntSize) {
        if (size.width <= 0 || size.height <= 0) return
        //bitmap = painter.paint(size.width, size.height)
        canvasSize = size
    }
}