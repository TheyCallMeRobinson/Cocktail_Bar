package surf.summerschool23.cocktailbar.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import surf.summerschool23.cocktailbar.presentation.viewmodel.CocktailDetailsViewModel
import surf.summerschool23.cocktailbar.presentation.viewmodel.CreateCocktailViewModel
import surf.summerschool23.cocktailbar.presentation.viewmodel.MainViewModel
import surf.summerschool23.cocktailbar.presentation.viewmodel.MyCocktailsBlankViewModel
import surf.summerschool23.cocktailbar.presentation.viewmodel.MyCocktailsViewModel

val presentationModule = module {
    viewModel<MyCocktailsBlankViewModel> {
        MyCocktailsBlankViewModel(getCocktailsCountUseCase = get())
    }

    viewModel<CreateCocktailViewModel> {
        CreateCocktailViewModel(createNewCocktailUseCase = get())
    }

    viewModel<MyCocktailsViewModel> {
        MyCocktailsViewModel(getAllCocktailsUseCase = get())
    }

    viewModel<MainViewModel> {
        MainViewModel()
    }

    viewModel<CocktailDetailsViewModel> {
        CocktailDetailsViewModel(getCocktailByTitleUseCase = get())
    }
}