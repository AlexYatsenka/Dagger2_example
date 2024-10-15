package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class IntoMapStringKeyModule {

    @Provides
    @IntoMap
    @StringKey("Google")
    @ActivityScope
    fun provideMapStringGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @IntoMap
    @StringKey("Facebook")
    @ActivityScope
    fun provideMapStringFacebookAnalytic() : Analytic = FacebookAnalytic()

}