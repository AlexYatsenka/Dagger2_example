package com.alexyatsenka.dagger2.models

import android.util.Log

class GoogleAnalytic : Analytic {
    override fun logAnalytic() {
        Log.v("Test", "Take screenshot by Google")
    }
}