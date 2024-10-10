package com.alexyatsenka.dagger2

import android.app.Application
import com.alexyatsenka.dagger2.di.Dagger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Dagger.buildAppComponent()
            .inject(this)
    }
}