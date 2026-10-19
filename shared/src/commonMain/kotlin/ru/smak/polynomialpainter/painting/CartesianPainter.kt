package ru.smak.polynomialpainter.painting

import java.awt.Color
import java.awt.image.BufferedImage

class CartesianPainter : Painter {

    override fun paint(width: Int, height: Int): BufferedImage {
        val image = BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_ARGB
        )
        val g2d = image.createGraphics()
        g2d.color = Color.WHITE
        g2d.fillRect(0, 0, width, height)

        g2d.color = Color.BLACK
        g2d.drawLine(0, height/2, width, height/2)
        g2d.drawLine(width/2, 0, width/2, height)
        return image
    }


}