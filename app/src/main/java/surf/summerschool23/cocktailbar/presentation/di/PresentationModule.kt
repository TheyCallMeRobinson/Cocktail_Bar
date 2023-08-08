package surf.summerschool23.cocktailbar.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import surf.summerschool23.cocktailbar.presentation.viewmodel.MyCocktailsBlankViewModel

val presentationModule = module {
    viewModel<MyCocktailsBlankViewModel> {
        MyCocktailsBlankViewModel(getCocktailsCountUseCase = get())
    }
}