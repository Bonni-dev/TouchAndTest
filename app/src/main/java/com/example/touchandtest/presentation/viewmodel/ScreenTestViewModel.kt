package com.example.touchandtest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.touchandtest.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class ScreenTestViewModel @Inject constructor() : ViewModel() {
    private var _timeOutMessage: MutableLiveData<String?> = MutableLiveData(null)
    private var _enabledButton: MutableLiveData<Boolean> = MutableLiveData(false)
    private var squareCount = 0

    val totalSquares = 36
    val timeOutMessage: LiveData<String?> = _timeOutMessage
    val enabledButton: LiveData<Boolean> = _enabledButton

    init {
        startCountDown()
    }

    private fun startCountDown() {
        viewModelScope.launch {
            for (i in 10 downTo 1) {
                delay(1000)
                if (i == 1) {
                    handleTestResult()
                }
            }
        }
    }

    fun handleTestResult() {
        if (areSquaresClicked()) {
            _enabledButton.value = areSquaresClicked()
        } else {
            showMessageToast(false)
        }
    }

    fun areSquaresClicked(): Boolean {
        return squareCount == totalSquares
    }

    fun showMessageToast(isSuccess: Boolean) {
        if (isSuccess) {
            _timeOutMessage.value = "O Teste Passou"
        } else {
            _timeOutMessage.value = "O Teste Falhou"
        }
    }

    fun incrementSquareCount() {
        squareCount++

    }

    fun handleNavigation(navController: NavController) {
        navController.navigate(Routes.HOME_SCREEN)
    }
}
