package surf.summerschool23.cocktailbar.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val currentCocktailTitle = MutableLiveData<String>()

    fun setCurrentCocktailTitle(title: String) {
        currentCocktailTitle.value = title
    }

    fun getCurrentCocktailTitle(): String {
        return currentCocktailTitle.value ?: ""
    }

}