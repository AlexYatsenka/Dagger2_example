package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.component.ActivitySubcomponent
import com.alexyatsenka.dagger2.di.map.Analytics
import com.alexyatsenka.dagger2.models.Analytic
import dagger.Module
import dagger.multibindings.Multibinds

@Module(
    subcomponents = [
        ActivitySubcomponent::class
    ]
)
abstract class MultibindsModule {
    @Multibinds abstract fun getSetAnalytics() : Set<Analytic>
    @Multibinds abstract fun getMapStringAnalytics() : Map<String, Analytic>
    @Multibinds abstract fun getMapClassAnalytics() : Map<Class<*>, Analytic>
    @Multibinds abstract fun getMapCustomAnalytics() : Map<Analytics, Analytic>
}