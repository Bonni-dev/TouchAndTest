package com.example.touchandtest.presentation.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.touchandtest.R
import com.example.touchandtest.presentation.theme.initialSquareColor
import com.example.touchandtest.presentation.theme.pressedSquareColor
import com.example.touchandtest.presentation.viewmodel.ScreenTestViewModel

@Composable
fun ScreenTestView(
    navController: NavController,
    viewModel: ScreenTestViewModel = hiltViewModel()
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val context = LocalContext.current
    val toastMessage by viewModel.timeOutMessage.collectAsState()

    Column(
        modifier = Modifier.size(screenHeight)
    ) {
        RowFactory(screenWidth, screenHeight, viewModel)
        SuccessButton(viewModel)
        TimeOutMessage(viewModel, navController, context, toastMessage)
    }
}

@Composable
fun RowFactory(
    screenWidth: Dp,
    screenHeight: Dp,
    viewModel: ScreenTestViewModel
) {
    val screenHeightPart = screenHeight / 9
    var rowPopulation = 0.dp

    while (rowPopulation < screenHeight) {
        Row(modifier = Modifier.height(screenHeightPart)) {
            SquareFactory(screenWidth, viewModel)
        }
        rowPopulation += screenHeightPart
    }
}

@Composable
fun SquareFactory(
    screenWidth: Dp,
    viewModel: ScreenTestViewModel
) {
    val screenWidthPart = screenWidth / 4
    var squarePopulation = 0.dp

    while (squarePopulation < screenWidth) {
        Button(
            modifier = Modifier.size(screenWidthPart),
            colors = initialSquareColor(),
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.White),
            onClick = { clickedSquared(viewModel) }
        ) {}
        squarePopulation += screenWidthPart
    }
}

@Composable
fun SuccessButton(
    viewModel: ScreenTestViewModel
) {
    viewModel.enabledButton.value?.let {
        Button(
            enabled = it,
            onClick = { onSuccessButtonClicked(viewModel) }) {
            Text(text = stringResource(R.string.success_message))
        }
    }
}

@Composable
fun TimeOutMessage(
    viewModel: ScreenTestViewModel,
    navController: NavController,
    context: Context,
    toastMessage: String?
) {
    LaunchedEffect(toastMessage) {
        toastMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }
    viewModel.handleNavigation(navController)
}

fun clickedSquared(viewModel: ScreenTestViewModel): ButtonColors {
    viewModel.incrementSquareCount()
    return pressedSquareColor()
}

fun onSuccessButtonClicked(viewModel: ScreenTestViewModel) {
    viewModel.showMessageToast(true)
}

@Preview(showBackground = true)
@Composable
fun ScreenTestViewPreview() {
    val navController = rememberNavController()
    ScreenTestView(navController)
}
