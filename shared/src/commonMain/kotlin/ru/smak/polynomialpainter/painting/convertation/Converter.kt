package ru.smak.polynomialpainter.painting.convertation

object Converter {
    fun xCrtToScr(x: Double, plane: Plane): Float{
        return ((x - plane.xMin) * plane.xDen).toFloat()
    }

    fun xScrToCrt(x: Float, plane: Plane): Double{
        return (x / plane.xDen) + plane.xMin
    }

    fun yCrtToScr(y: Double, plane: Plane): Float{
        return ((plane.yMax - y) * plane.yDen).toFloat()
    }

    fun yScrToCrt(y: Float, plane: Plane): Double{
        return plane.yMax - (y / plane.yDen)
    }
}

