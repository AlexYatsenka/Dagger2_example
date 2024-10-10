package com.alexyatsenka.dagger2

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainViewModel @AssistedInject constructor(
    private val googleAnalytic: GoogleAnalytic,
    private val facebookAnalytic: FacebookAnalytic,
    @Assisted private val someId : Int
) : ViewModel() {

    fun logScreenshot() {
        Log.v("Test", "Inject by constructor + assisted ($someId)")
        googleAnalytic.logAnalytic()
        facebookAnalytic.logAnalytic()
    }

    @AssistedFactory
    interface Factory {
        fun create(someId: Int) : MainViewModel
    }
}