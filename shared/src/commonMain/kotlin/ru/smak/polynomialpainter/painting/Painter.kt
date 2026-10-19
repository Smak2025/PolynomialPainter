package ru.smak.polynomialpainter.painting

import java.awt.image.BufferedImage

interface Painter {
    fun paint(width: Int, height: Int): BufferedImage
}