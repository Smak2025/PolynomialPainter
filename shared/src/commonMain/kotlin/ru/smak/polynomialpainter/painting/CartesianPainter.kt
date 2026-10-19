package ru.smak.polynomialpainter.painting

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

class CartesianPainter : Painter {

    override fun DrawScope.paint() {

//        val image = BufferedImage(
//            width,
//            height,
//            BufferedImage.TYPE_INT_ARGB
//        )
//        val g2d = image.createGraphics()
//        g2d.color = Color.WHITE
//        g2d.fillRect(0, 0, width, height)

//        g2d.color = Color.BLACK
//        g2d.drawLine(0, height/2, width, height/2)
//        g2d.drawLine(width/2, 0, width/2, height)
//        return image.toComposeImageBitmap()
        drawLine(
            Color.Black,
            Offset(0f, size.height/2),
            Offset(size.width, size.height/2),
            strokeWidth = 1f,
        )
        drawLine(
            Color.Black,
            Offset(size.width / 2, 0f),
            Offset(size.width / 2, size.height),
            strokeWidth = 1f,
        )
    }


}