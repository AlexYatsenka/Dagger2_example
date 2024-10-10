package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.map.AnalyticMapKey
import com.alexyatsenka.dagger2.di.map.Analytics
import com.alexyatsenka.dagger2.models.Analytic
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import javax.inject.Named
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.di.map.FacebookAnalytic as FacebookQualifier
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.multibindings.ElementsIntoSet
import com.alexyatsenka.dagger2.di.map.GoogleAnalytic as GoogleQualifier

@Module
class ActivityModule {

    @Provides
    @ElementsIntoSet
    @ActivityScope
    fun provideAnalytics() : Set<Analytic> = setOf(
        GoogleAnalytic(),
        FacebookAnalytic()
    )

    // IntoSet
    @Provides
    @IntoSet
    @ActivityScope
    fun provideSetGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @IntoSet
    @ActivityScope
    fun provideSetFacebookAnalytic() : Analytic = FacebookAnalytic()

    // IntoMap (@StringKey)
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

    // IntoMap (@ClassKey)
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

    // IntoMap (Custom key)
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

    // Named
    @Provides
    @Named("Google")
    @ActivityScope
    fun provideNamedGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @Named("Facebook")
    @ActivityScope
    fun provideNamedFacebookAnalytic() : Analytic = FacebookAnalytic()

    // Qualifier
    @Provides
    @GoogleQualifier
    @ActivityScope
    fun provideQualifierGoogleAnalytic() : Analytic = GoogleAnalytic()

    @Provides
    @FacebookQualifier
    @ActivityScope
    fun provideQualifierFacebookAnalytic() : Analytic = FacebookAnalytic()

}