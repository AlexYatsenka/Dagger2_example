package com.alexyatsenka.dagger2.di.component

import com.alexyatsenka.dagger2.MainActivity
import com.alexyatsenka.dagger2.MainViewModel
import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.modules.ActivityModule
import com.alexyatsenka.dagger2.di.modules.ViewModelModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface ActivitySubcomponent {
    fun inject(activity: MainActivity)
    fun getViewModel() : MainViewModel.Factory

    @Subcomponent.Builder
    interface Builder {
        fun build() : ActivitySubcomponent
    }
}