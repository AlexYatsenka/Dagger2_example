package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class IntoMapClassKeyModule {

    @Provides
    @IntoMap
    @ClassKey(GoogleAnalytic::class)
    @ActivityScope
    fun provideMapClassGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @IntoMap
    @ClassKey(FacebookAnalytic::class)
    @ActivityScope
    fun provideMapClassFacebookAnalytic() : Analytic = FacebookAnalytic()

}