package com.alexyatsenka.dagger2.di.map

import dagger.MapKey

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class AnalyticMapKey(val value : Analytics)