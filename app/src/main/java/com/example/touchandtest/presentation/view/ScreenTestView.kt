package com.example.touchandtest.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScreenTestView() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier.size(screenHeight)
    ) {
        RowFactory(screenWidth, screenHeight)
    }
}

@Composable
fun RowFactory(screenWidth: Dp, screenHeight: Dp) {
    val screenHeightPart = screenHeight/9
    var rowPopulation = 0.dp

    while (rowPopulation < screenHeight) {
        Row(modifier = Modifier.height(screenHeightPart)) {
            SquareFactory(screenWidth)
        }
        rowPopulation += screenHeightPart
    }
}

@Composable
fun SquareFactory(screenWidth: Dp) {
    val screenWidthPart = screenWidth/4
    var squarePopulation = 0.dp
    var squareColor = Color.LightGray

    while (squarePopulation < screenWidth) {
        Button(
            modifier = Modifier
                .size(screenWidthPart)
                .background(color = squareColor),
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.White),
            onClick = { squareColor = Color.Green }
        ) {}
        squarePopulation += screenWidthPart
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTestViewPreview() {
    ScreenTestView()
}