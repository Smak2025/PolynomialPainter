package ru.smak.polynomialpainter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.smak.polynomialpainter.painting.convertation.Plane
import ru.smak.polynomialpainter.viewmodels.ValueType

@Composable
fun UserInputPanel(
    plane: Plane,
    modifier: Modifier = Modifier,
    onValueChange: (ValueType, Double) -> Unit = { _, _ -> },
){
    var xMin by remember { mutableStateOf(plane.xMin.toString()) }
    var xMax by remember { mutableStateOf(plane.xMax.toString()) }
    var yMin by remember { mutableStateOf(plane.yMin.toString()) }
    var yMax by remember { mutableStateOf(plane.yMax.toString()) }

    Box(modifier = modifier) {
        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(16.dp)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserDoubleInput(
                    "xMin:",
                    xMin,
                    modifier = Modifier.weight(1f),
                    onUserInput = { input ->
                        xMin = input
                        input.toDoubleOrNull()?.let{ onValueChange(ValueType.X_MIN, it) }
                    },
                )
                Spacer(modifier = Modifier.width(16.dp))
                UserDoubleInput(
                    "xMax:",
                    xMax,
                    modifier = Modifier.weight(1f),
                    onUserInput = { input ->
                        xMax = input
                        input.toDoubleOrNull()?.let{ onValueChange(ValueType.X_MAX, it) }
                    },
                )
            }
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserDoubleInput(
                    "yMin:",
                    yMin,
                    modifier = Modifier.weight(1f),
                    onUserInput = { input ->
                        yMin = input
                        input.toDoubleOrNull()?.let{ onValueChange(ValueType.Y_MIN, it) }
                    },
                )
                Spacer(modifier = Modifier.width(16.dp))
                UserDoubleInput(
                    "yMax:",
                    yMax,
                    modifier = Modifier.weight(1f),
                    onUserInput = { input ->
                        yMax = input
                        input.toDoubleOrNull()?.let{ onValueChange(ValueType.Y_MAX, it) }
                    },
                )
            }
        }
    }
}
@Composable
fun UserDoubleInput(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onUserInput: (String) -> Unit = {},
){
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label)
        TextField(
            value = value,
            onValueChange = {
                it.trim().apply{
                    toDoubleOrNull()?.also {
                        onUserInput(this)
                    } ?: run {
                        if (isEmpty()
                            || this == "-"
                            || (this.endsWith(".") && this.slice(0..< length-1).toIntOrNull() != null)
                            || (this.startsWith(".") && this.slice(1..< length).toIntOrNull() != null)
                        ){
                            onUserInput(this)
                        }
                    }
                }
            },
            modifier = Modifier.weight(1f),
            singleLine = true,
        )
    }
}