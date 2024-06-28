package com.example.touchandtest.shared

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TouchAndTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Coming_inside_onCreate")
    }

    companion object {
        const val TAG = "TouchAndTestApplication"
    }
}
