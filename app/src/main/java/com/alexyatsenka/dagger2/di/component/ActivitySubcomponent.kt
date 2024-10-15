package com.alexyatsenka.dagger2.di.component

import com.alexyatsenka.dagger2.MainActivity
import com.alexyatsenka.dagger2.MainViewModel
import com.alexyatsenka.dagger2.di.ActivityScope
import com.alexyatsenka.dagger2.di.modules.ElementsIntoSetModule
import com.alexyatsenka.dagger2.di.modules.IntoMapClassKeyModule
import com.alexyatsenka.dagger2.di.modules.IntoMapCustomKeyModule
import com.alexyatsenka.dagger2.di.modules.IntoMapStringKeyModule
import com.alexyatsenka.dagger2.di.modules.IntoSetModule
import com.alexyatsenka.dagger2.di.modules.NamedModule
import com.alexyatsenka.dagger2.di.modules.ProvidesModule
import com.alexyatsenka.dagger2.di.modules.QualifierModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ElementsIntoSetModule::class,
        ProvidesModule::class,
        NamedModule::class,
        QualifierModule::class,
        IntoSetModule::class,
        IntoMapStringKeyModule::class,
        IntoMapClassKeyModule::class,
        IntoMapCustomKeyModule::class
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