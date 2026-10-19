package ru.smak.polynomialpainter.painting.convertation

object Converter {
    fun xCrtToScr(x: Double, plane: Plane): Int{
        return ((x - plane.xMin) * plane.xDen).toInt()
    }


    fun xScrToCrt(x: Int, plane: Plane): Double{
        return (x / plane.xDen) + plane.xMin
    }

    fun yCrtToScr(y: Double, plane: Plane): Int{
        return ((plane.yMax - y) * plane.yDen).toInt()
    }

    fun yScrToCrt(y: Int, plane: Plane): Double{
        return plane.yMax - (y / plane.yDen)
    }
}

