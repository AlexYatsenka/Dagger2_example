package com.alexyatsenka.dagger2.models

import android.util.Log

class FacebookAnalytic : Analytic {
    override fun logAnalytic() {
        Log.v("Test", "Take screenshot by Facebook")
    }
}