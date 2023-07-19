package com.example.pizzaanimation.ui.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getImageSize(selectedChip: String): Dp {
    return when (selectedChip) {
        "S" -> 180.dp
        "M" -> 200.dp
        "L" -> 220.dp
        else -> 180.dp
    }
}
