package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class IntoSetModule {

    @Provides
    @IntoSet
    @ActivityScope
    fun provideSetGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @IntoSet
    @ActivityScope
    fun provideSetFacebookAnalytic() : Analytic = FacebookAnalytic()
}