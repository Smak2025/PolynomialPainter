package ru.smak.polynomialpainter.painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.smak.polynomialpainter.painting.convertation.Converter
import ru.smak.polynomialpainter.painting.convertation.Plane

class CartesianPainter : Painter {

    override fun DrawScope.paint(plane: Plane) {
        paintAxis(plane)
    }

    private fun DrawScope.paintAxis(plane: Plane){
        val x0 = Converter.xCrtToScr(0.0, plane)
        val y0 = Converter.yCrtToScr(0.0, plane)
        drawLine(
            Color.Black,
            Offset(0f, y0),
            Offset(size.width, y0),
            strokeWidth = 1f,
        )
        drawLine(
            Color.Black,
            Offset(x0, 0f),
            Offset(x0, size.height),
            strokeWidth = 1f,
        )
    }
}