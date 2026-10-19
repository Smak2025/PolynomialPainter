package ru.smak.polynomialpainter.painting

import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.smak.polynomialpainter.painting.convertation.Plane

interface Painter {
    fun DrawScope.paint(plane: Plane)
}