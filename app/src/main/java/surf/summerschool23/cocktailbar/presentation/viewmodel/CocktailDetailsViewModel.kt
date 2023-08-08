package surf.summerschool23.cocktailbar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import surf.summerschool23.cocktailbar.data.environment.Resource
import surf.summerschool23.cocktailbar.domain.usecase.GetCocktailByTitleUseCase

class CocktailDetailsViewModel(
    private val getCocktailByTitleUseCase: GetCocktailByTitleUseCase
) : ViewModel() {

    fun getCocktailByTitle(title: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = getCocktailByTitleUseCase.execute(title)))
        } catch (e: Exception) {
            emit(Resource.error(null, message = "Error loading detail data"))
        }
    }
}