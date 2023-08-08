package surf.summerschool23.cocktailbar.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers

import surf.summerschool23.cocktailbar.data.environment.Resource
import surf.summerschool23.cocktailbar.domain.usecase.GetAllCocktailsUseCase
import androidx.lifecycle.liveData
import surf.summerschool23.cocktailbar.data.environment.Status

class MyCocktailsViewModel(
    private val getAllCocktailsUseCase: GetAllCocktailsUseCase
) : ViewModel() {

    fun getAllCocktailsList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val data = getAllCocktailsUseCase.execute()
            emit(Resource(status = Status.SUCCESS, data = data, message = ""))
        } catch (e: Exception) {
            emit(Resource(status = Status.ERROR, data = null, message = e.message))
        }
    }
}