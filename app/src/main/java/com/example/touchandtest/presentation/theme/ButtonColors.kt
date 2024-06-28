package com.example.touchandtest.presentation.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color

fun initialSquareColor() =
    ButtonColors(
        containerColor = Color.LightGray,
        contentColor = Color.LightGray,
        disabledContainerColor = Color.LightGray,
        disabledContentColor = Color.LightGray
    )

fun pressedSquareColor() =
    ButtonColors(
        containerColor = Color.Green,
        contentColor = Color.Green,
        disabledContainerColor = Color.Green,
        disabledContentColor = Color.Green
    )
