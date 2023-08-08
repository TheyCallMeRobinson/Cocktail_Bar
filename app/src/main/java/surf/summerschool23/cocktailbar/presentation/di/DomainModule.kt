package surf.summerschool23.cocktailbar.presentation.di

import org.koin.dsl.module
import surf.summerschool23.cocktailbar.domain.usecase.CreateNewCocktailUseCase
import surf.summerschool23.cocktailbar.domain.usecase.GetAllCocktailsUseCase
import surf.summerschool23.cocktailbar.domain.usecase.GetCocktailByTitleUseCase
import surf.summerschool23.cocktailbar.domain.usecase.GetCocktailsCountUseCase
import surf.summerschool23.cocktailbar.domain.usecase.UpdateCocktailUseCase

val domainModule = module {

    factory<CreateNewCocktailUseCase> {
        CreateNewCocktailUseCase(cocktailRepository = get())
    }

    factory<GetAllCocktailsUseCase> {
        GetAllCocktailsUseCase(cocktailRepository = get())
    }

    factory<GetCocktailsCountUseCase> {
        GetCocktailsCountUseCase(cocktailRepository = get())
    }

    factory<UpdateCocktailUseCase> {
        UpdateCocktailUseCase(cocktailRepository = get())
    }

    factory<GetCocktailByTitleUseCase> {
        GetCocktailByTitleUseCase(cocktailRepository = get())
    }
}