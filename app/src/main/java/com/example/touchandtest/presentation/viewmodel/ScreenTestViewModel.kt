package com.example.touchandtest.presentation.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.touchandtest.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ScreenTestViewModel @Inject constructor() : ViewModel() {
    private var _timeOutMessage: MutableLiveData<String?> = MutableLiveData(null)
    private var _enabledButton: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _squaresState = MutableLiveData<List<Boolean>>(emptyList())
    private var squareCount = 0
    private var timer: CountDownTimer? = null

    var isFinish = false
    val totalSquares = 36
    val timeOutMessage: LiveData<String?> = _timeOutMessage
    val enabledButton: LiveData<Boolean> = _enabledButton
    val squaresState: MutableLiveData<List<Boolean>> = _squaresState


    init {
        _squaresState.value = List(36) { true }
        startCountDown()
    }

    private fun startCountDown() {
        timer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("DEBUG", "${millisUntilFinished/1000} restantes")
            }

            override fun onFinish() {
                isFinish = true
                handleTestResult()
                Log.d("DEBUG", "finish countDown")
            }
        }.start()
    }

    fun onSquareClicked(index: Int) {
        _squaresState.value = _squaresState.value?.mapIndexed { i, state ->
            if (i == index) false else state
        }!!
        incrementSquareCount()
    }

    fun handleTestResult() {
        if (allSquaresClicked()) {
            _enabledButton.value = allSquaresClicked()
            Log.d("DEBUG", "${_enabledButton.value}")
        } else {
            showMessageToast(false)
        }
    }

    fun allSquaresClicked(): Boolean {
        Log.d("DEBUG", "$squareCount e $totalSquares")
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
        Log.d("DEBUG", "$squareCount")
    }

    fun handleNavigation(navController: NavController) {
        if (isFinish){
            navController.navigate(Routes.HOME_SCREEN)
        }
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}
