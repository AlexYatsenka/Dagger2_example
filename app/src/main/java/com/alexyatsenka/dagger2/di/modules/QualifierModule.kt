package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.map.FacebookAnalyticQualifier
import com.alexyatsenka.dagger2.di.map.GoogleAnalyticQualifier
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides

@Module
class QualifierModule {

    @Provides
    @GoogleAnalyticQualifier
    @ActivityScope
    fun provideQualifierGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @FacebookAnalyticQualifier
    @ActivityScope
    fun provideQualifierFacebookAnalytic() : Analytic = FacebookAnalytic()
}