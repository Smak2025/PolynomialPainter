package ru.smak.polynomialpainter.painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.smak.polynomialpainter.painting.convertation.Converter
import ru.smak.polynomialpainter.painting.convertation.Plane
import kotlin.math.sin

class FunctionPainter(
    val function: (Double)->Double,
    val color: Color = Color.Red,
) : Painter{
    override fun DrawScope.paint(plane: Plane) {
        for(xs in 0..<plane.width){
            val xc1 = Converter.xScrToCrt(xs.toFloat(), plane)
            val xc2 = Converter.xScrToCrt(xs + 1f, plane)
            val ys1 = Converter.yCrtToScr(function(xc1), plane)
            val ys2 = Converter.yCrtToScr(function(xc2), plane)
            drawLine(
                color,
                Offset(xs.toFloat(), ys1),
                Offset(xs + 1f, ys2)
            )
        }
    }
}