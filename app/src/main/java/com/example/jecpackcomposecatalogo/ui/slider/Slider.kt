package com.example.jecpackcomposecatalogo.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by rememberSaveable { mutableStateOf(0f) }
        var completedvalue by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completedvalue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = false
        )
        Text(text = completedvalue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..40f,
            steps = 9
        )
        Text(text = "valor Inferior ${currentRange.start}")
        Text(text = "valor Superior ${currentRange.endInclusive}")
    }

}