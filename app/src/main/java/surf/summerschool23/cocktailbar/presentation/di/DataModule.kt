package surf.summerschool23.cocktailbar.presentation.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import surf.summerschool23.cocktailbar.data.db.CocktailDAO
import surf.summerschool23.cocktailbar.data.db.CocktailDatabase
import surf.summerschool23.cocktailbar.data.mapper.CocktailMapper
import surf.summerschool23.cocktailbar.data.repository.CocktailRepositoryImpl
import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

val dataModule = module {

    single<CocktailDatabase> {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            CocktailDatabase::class.java,
            "cocktail-database"
        ).fallbackToDestructiveMigration().build()
    }

    single<CocktailDAO> {
        get<CocktailDatabase>().cocktailDao()
    }

    single<CocktailRepository> {
        CocktailRepositoryImpl(
            cocktailDAO = get(),
            cocktailMapper = get()
        )
    }

    single<CocktailMapper> {
        CocktailMapper()
    }
}