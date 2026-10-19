package ru.smak.polynomialpainter

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import ru.smak.polynomialpainter.viewmodels.MainViewModel

@Composable
@Preview
fun App(vm: MainViewModel = remember {MainViewModel()}) {
    val bitmap = remember (vm.canvasSize){
        if (vm.canvasSize.width != 0 && vm.canvasSize.height != 0){
            vm.render().toComposeImageBitmap()
        } else {
            null
        }

    }
    MaterialTheme {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .onSizeChanged {
                vm.canvasSize = it
            }
        ){
            bitmap?.let { drawImage(it) }
        }
    }
}