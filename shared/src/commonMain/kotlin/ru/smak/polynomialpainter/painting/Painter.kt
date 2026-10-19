package ru.smak.polynomialpainter.painting

import androidx.compose.ui.graphics.drawscope.DrawScope

interface Painter {
    fun DrawScope.paint()
}