package com.example.touchandtest.presentation.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.touchandtest.R
import com.example.touchandtest.navigation.Routes
import com.example.touchandtest.presentation.theme.initialSquareColor
import com.example.touchandtest.presentation.theme.standardButtonColor
import com.example.touchandtest.presentation.viewmodel.ScreenTestViewModel

@Composable
fun ScreenTestView(
    navController: NavController,
    viewModel: ScreenTestViewModel = hiltViewModel()
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val context = LocalContext.current
    val timeOutMessage by viewModel.timeOutMessage.observeAsState(null)
    val enabledButton by viewModel.enabledButton.observeAsState(false)


    Column(
        modifier = Modifier.size(screenWidth, screenHeight),
    ) {
        RowFactory(screenWidth, screenHeight, viewModel)
    }

    if (enabledButton) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0f, 0f, 0f, 0f)),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(modifier = Modifier
                .padding(48.dp)
                .fillMaxWidth()
                .zIndex(10f),
                enabled = true,
                colors = standardButtonColor(),
                onClick = { onSuccessButtonClicked(viewModel) }
            ) {
                Text(text = stringResource(R.string.success_message))
            }
        }
    }

    timeOutMessage?.let {
        TimeOutMessage(viewModel, navController, context, it)
    }
}

@Composable
fun RowFactory(
    screenWidth: Dp,
    screenHeight: Dp,
    viewModel: ScreenTestViewModel,
) {
    val screenHeightPart = screenHeight / 9
    var rowPopulation = 0.dp
    var currentIndex = 0

    while (rowPopulation < screenHeight) {
        Row(modifier = Modifier.height(screenHeightPart)) {
            SquareFactory(screenWidth, viewModel, currentIndex)
            currentIndex += 4
        }
        rowPopulation += screenHeightPart
    }
}

@Composable
fun SquareFactory(
    screenWidth: Dp,
    viewModel: ScreenTestViewModel,
    startIndex: Int
) {
    val squaresState by viewModel.squaresState.observeAsState(initial = List(36) { true })
    val screenWidthPart = screenWidth / 4
    var squarePopulation = 0.dp

    for (i in 0 until 4) {
        val index = startIndex + i
        val enabledSquare = squaresState.getOrNull(index) ?: true

        Button(
            modifier = Modifier
                .size(screenWidthPart)
                .zIndex(0f),
            colors = initialSquareColor(),
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.White),
            enabled = enabledSquare,
            onClick = {
                viewModel.onSquareClicked(index)
            }
        ) {}
        squarePopulation += screenWidthPart
    }
}

@Composable
fun TimeOutMessage(
    viewModel: ScreenTestViewModel,
    navController: NavController,
    context: Context,
    timeOutMessage: String
) {
    LaunchedEffect(timeOutMessage) {
        Toast.makeText(context, timeOutMessage, Toast.LENGTH_LONG).show()
    }
    handleNavigation(viewModel, navController)
}

fun handleNavigation(viewModel: ScreenTestViewModel, navController: NavController) {
    if (viewModel.isFinish.value == true) {
        navController.navigate(Routes.HOME_SCREEN)
    }
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
