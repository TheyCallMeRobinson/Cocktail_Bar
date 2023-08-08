package surf.summerschool23.cocktailbar.domain.usecase

import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

class CreateNewCocktailUseCase(private val cocktailRepository: CocktailRepository) {

    suspend fun execute(newCocktail: CocktailEntity) {
        cocktailRepository.createNewCocktail(newCocktail)
    }
}