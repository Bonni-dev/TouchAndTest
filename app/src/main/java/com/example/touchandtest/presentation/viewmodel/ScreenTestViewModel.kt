package com.example.touchandtest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenTestViewModel @Inject constructor() : ViewModel() {
    private var _timeOutMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    private var _enabledButton: MutableLiveData<Boolean> = MutableLiveData(false)
    private var squareCount = 0
    private val totalSquares = 36

    val timeOutMessage: StateFlow<String?> = _timeOutMessage
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

    private fun handleTestResult() {
        if (areSquaresClicked()) {
            _enabledButton.value = areSquaresClicked()
        } else {
            showMessageToast(false)
        }
    }

    private fun areSquaresClicked(): Boolean {
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
}