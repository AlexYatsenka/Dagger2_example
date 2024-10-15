package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.map.AnalyticMapKey
import com.alexyatsenka.dagger2.di.map.Analytics
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class IntoMapCustomKeyModule {

    @Provides
    @IntoMap
    @AnalyticMapKey(Analytics.GOOGLE)
    @ActivityScope
    fun provideMapAnnotationGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @IntoMap
    @AnalyticMapKey(Analytics.FACEBOOK)
    @ActivityScope
    fun provideMapAnnotationFacebookAnalytic() : Analytic = FacebookAnalytic()

}