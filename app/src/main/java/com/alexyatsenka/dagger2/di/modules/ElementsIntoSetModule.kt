package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.models.Analytic
import dagger.Module
import dagger.Provides
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.multibindings.ElementsIntoSet

@Module
class ElementsIntoSetModule {

    @Provides
    @ElementsIntoSet
    @ActivityScope
    fun provideAnalytics() : Set<Analytic> = setOf(
        GoogleAnalytic(),
        FacebookAnalytic()
    )

}