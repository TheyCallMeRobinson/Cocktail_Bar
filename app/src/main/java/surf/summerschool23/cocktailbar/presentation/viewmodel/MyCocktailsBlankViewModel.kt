package surf.summerschool23.cocktailbar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import surf.summerschool23.cocktailbar.data.environment.Resource
import surf.summerschool23.cocktailbar.data.environment.Status
import surf.summerschool23.cocktailbar.domain.usecase.GetCocktailsCountUseCase

class MyCocktailsBlankViewModel(
    private val getCocktailsCountUseCase: GetCocktailsCountUseCase
) : ViewModel() {

    fun getCocktailsCount() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val cocktailsCount = getCocktailsCountUseCase.execute()
            emit(Resource.success(data = cocktailsCount))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = "Error loading cocktails"))
        }
    }
}