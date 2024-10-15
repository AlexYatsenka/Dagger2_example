package com.alexyatsenka.dagger2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexyatsenka.dagger2.di.Dagger
import com.alexyatsenka.dagger2.di.map.Analytics
import com.alexyatsenka.dagger2.models.Analytic
import com.alexyatsenka.dagger2.models.FacebookAnalytic
import com.alexyatsenka.dagger2.models.GoogleAnalytic
import com.alexyatsenka.dagger2.di.map.GoogleAnalyticQualifier as GoogleQualifier
import com.alexyatsenka.dagger2.di.map.FacebookAnalyticQualifier as FacebookQualifier
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory : MainViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Dagger.appComponent.getActivitySubcomponent()
            .build()
            .inject(this)

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModelFactory.create(123).logScreenshot()
    }

    @Inject
    fun logScreenshotSet(
        analytic: Set<@JvmSuppressWildcards Analytic>
    ) {
        Log.v("Test", "Inject @IntoSet & @ElementsIntoSet")
        analytic.forEach {
            it.logAnalytic()
        }
    }

    @Inject
    fun logScreenshotStringMapString(
        analytic: Map<String, @JvmSuppressWildcards Analytic>
    ) {
        Log.v("Test", "Inject @IntoMap (@StringKey)")
        analytic["Google"]?.logAnalytic()
        analytic["Facebook"]?.logAnalytic()
    }

    @Inject
    fun logScreenshotClass(
        analytic: Map<Class<*>, @JvmSuppressWildcards Analytic>
    ) {
        Log.v("Test", "Inject @IntoMap (@ClassKey)")
        analytic[GoogleAnalytic::class.java]?.logAnalytic()
        analytic[FacebookAnalytic::class.java]?.logAnalytic()
    }

    @Inject
    fun logScreenshotCustomKey(
        analytic: Map<Analytics, @JvmSuppressWildcards Analytic>
    ) {
        Log.v("Test", "Inject @IntoMap (Custom key)")
        analytic[Analytics.GOOGLE]?.logAnalytic()
        analytic[Analytics.FACEBOOK]?.logAnalytic()
    }

    @Inject
    fun logScreenshotNamed(
        @Named("Google") googleAnalytic : Analytic,
        @Named("Facebook") facebookAnalytic: Analytic
    ) {
        Log.v("Test", "Inject @Named")
        googleAnalytic.logAnalytic()
        facebookAnalytic.logAnalytic()
    }

    @Inject
    fun logScreenshotQualifier(
        @GoogleQualifier googleAnalytic : Analytic,
        @FacebookQualifier facebookAnalytic: Analytic
    ) {
        Log.v("Test", "Inject @Qualifier")
        googleAnalytic.logAnalytic()
        facebookAnalytic.logAnalytic()
    }
}