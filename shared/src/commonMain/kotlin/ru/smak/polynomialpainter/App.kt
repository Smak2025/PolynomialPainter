package ru.smak.polynomialpainter

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import ru.smak.polynomialpainter.painting.Painter
import ru.smak.polynomialpainter.ui.UserInputPanel
import ru.smak.polynomialpainter.viewmodels.MainViewModel
import ru.smak.polynomialpainter.viewmodels.ValueType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App(
    vm: MainViewModel,
    vararg painters: Painter,
) {
    MaterialTheme {
        var clickPosition by remember { mutableStateOf(Offset.Zero) }
        Column(modifier = Modifier.fillMaxSize()) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.White)
                    .onSizeChanged { vm.onCanvasSizeChange(it) }
                    .onPointerEvent(PointerEventType.Press) { event ->
                        val pos = event.changes.first().position  // Offset в пикселях, относительно Canvas
                        clickPosition = pos
                    }
            ) {
                for (painter in painters) {
                    with(painter) { paint(vm.plane) }
                }
                drawCircle(Color.Cyan, 5f, clickPosition)
            }
            UserInputPanel(
                vm.plane,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = vm::changeValue
            )
        }
    }
}