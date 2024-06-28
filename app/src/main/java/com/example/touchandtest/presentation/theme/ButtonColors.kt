package com.example.touchandtest.presentation.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color

fun initialButtonColor() =
    ButtonColors(
        containerColor = Color.Blue,
        contentColor = Color.Yellow,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.Black
    )

fun initialSquareColor() =
    ButtonColors(
        containerColor = Color.LightGray,
        contentColor = Color.LightGray,
        disabledContainerColor = Color.Green,
        disabledContentColor = Color.Green
    )
