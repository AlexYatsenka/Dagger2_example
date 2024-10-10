package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.component.ActivitySubcomponent
import com.alexyatsenka.dagger2.models.Analytic
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds

@Module(
    subcomponents = [
        ActivitySubcomponent::class
    ]
)
abstract class AppModule {
    @Multibinds abstract fun getSetAnalytics() : Set<Analytic>
    @Multibinds abstract fun getMapStringAnalytics() : Map<String, Analytic>
    @Multibinds abstract fun getMapClassAnalytics() : Map<Class<*>, Analytic>
}