package surf.summerschool23.cocktailbar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.domain.usecase.CreateNewCocktailUseCase

class CreateCocktailViewModel(
    private val createNewCocktailUseCase: CreateNewCocktailUseCase,
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun saveNewCocktail(cocktailEntity: CocktailEntity) {
        scope.launch {
            createNewCocktailUseCase.execute(cocktailEntity)
        }
    }
}