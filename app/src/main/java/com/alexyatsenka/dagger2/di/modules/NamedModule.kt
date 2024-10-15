package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NamedModule {

    @Provides
    @Named("Google")
    @ActivityScope
    fun provideNamedGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @Named("Facebook")
    @ActivityScope
    fun provideNamedFacebookAnalytic() : Analytic = FacebookAnalytic()

}