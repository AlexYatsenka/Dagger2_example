package com.alexyatsenka.dagger2.di.component

import com.alexyatsenka.dagger2.App
import com.alexyatsenka.dagger2.di.modules.MultibindsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MultibindsModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun getActivitySubcomponent() : ActivitySubcomponent.Builder

    @Component.Factory
    interface Factory {
        fun create() : AppComponent
    }
}