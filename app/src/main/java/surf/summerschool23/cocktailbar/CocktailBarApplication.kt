package surf.summerschool23.cocktailbar

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import surf.summerschool23.cocktailbar.presentation.di.dataModule
import surf.summerschool23.cocktailbar.presentation.di.domainModule
import surf.summerschool23.cocktailbar.presentation.di.presentationModule

class CocktailBarApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CocktailBarApplication)
            fragmentFactory()
            modules(listOf(presentationModule, dataModule, domainModule))
        }
    }
}