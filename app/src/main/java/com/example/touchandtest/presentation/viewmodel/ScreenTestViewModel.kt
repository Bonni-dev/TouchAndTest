package com.example.touchandtest.presentation.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenTestViewModel @Inject constructor() : ViewModel() {
    private val _squaresState = MutableLiveData<List<Boolean>>(emptyList())
    private var _timeOutMessage: MutableLiveData<String?> = MutableLiveData(null)
    private var _enabledButton: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isFinish: MutableLiveData<Boolean>  = MutableLiveData(false)
    private var squareCount = 0
    private var timer: CountDownTimer? = null

    val squaresState: LiveData<List<Boolean>> = _squaresState
    val timeOutMessage: LiveData<String?> = _timeOutMessage
    val enabledButton: LiveData<Boolean> = _enabledButton
    val isFinish: LiveData<Boolean> = _isFinish
    val totalSquares = 36


    init {
        _squaresState.value = List(36) { true }
        startCountDown()
    }

    private fun startCountDown() {
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.i("COUNTDOWN", "${millisUntilFinished / 1000}")
            }

            override fun onFinish() {
                _isFinish.value = true
                handleTestResult()
            }
        }.start()
    }

    fun handleTestResult() {
        if (isAllSquaresClicked()) {
            _enabledButton.value = isAllSquaresClicked()
        } else {
            showMessageToast(false)
        }
    }

    fun isAllSquaresClicked(): Boolean {
        return squareCount == totalSquares
    }

    fun showMessageToast(isSuccess: Boolean) {
        if (isSuccess) {
            _timeOutMessage.value = "O Teste Passou"
        } else {
            _timeOutMessage.value = "O Teste Falhou"
        }
    }

    fun onSquareClicked(index: Int) {
        _squaresState.value = _squaresState.value?.mapIndexed { i, state ->
        if (i == index) false else state
        }!!
        incrementSquareCount()
    }

    fun incrementSquareCount() {
        squareCount++
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}

