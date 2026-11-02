package ru.smak.polynomialpainter.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import ru.smak.polynomialpainter.painting.convertation.Plane

class MainViewModel : ViewModel() {

    var plane by mutableStateOf(Plane(
        -5.0,
        5.0,
        -5.0,
        5.0,
        0,
        0
    ))

    fun onCanvasSizeChange(size: IntSize) {
        if (size.width <= 0 || size.height <= 0) return
        plane = plane.copy(width = size.width, height = size.height)
    }

    fun changeValue(type: ValueType, value: Double) {
        when(type){
            ValueType.X_MIN -> { plane = plane.copy(xMin = value) }
            ValueType.X_MAX -> { plane = plane.copy(xMax = value) }
            ValueType.Y_MIN -> { plane = plane.copy(yMin = value) }
            ValueType.Y_MAX -> { plane = plane.copy(yMax = value) }
        }
    }
}