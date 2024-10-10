package com.alexyatsenka.dagger2.di.modules

import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ViewModelModule {

    @Provides
    @Reusable
    fun provideGoogleAnalytic() = GoogleAnalytic()

    @Provides
    @Reusable
    fun provideFacebookAnalytic() = FacebookAnalytic()
}