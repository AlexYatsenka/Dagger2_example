package com.alexyatsenka.dagger2.di

import com.alexyatsenka.dagger2.di.component.AppComponent
import com.alexyatsenka.dagger2.di.component.DaggerAppComponent

object Dagger {
    private var mAppComponent : AppComponent? = null
    val appComponent get() = mAppComponent!!

    @JvmStatic
    fun buildAppComponent() : AppComponent {
        if(mAppComponent == null) {
            synchronized(this) {
                if(mAppComponent == null) {
                    mAppComponent = DaggerAppComponent.create()
                }
            }
        }
        return appComponent
    }
}