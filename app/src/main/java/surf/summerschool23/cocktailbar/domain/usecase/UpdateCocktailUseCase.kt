package surf.summerschool23.cocktailbar.domain.usecase

import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

class UpdateCocktailUseCase(private val cocktailRepository: CocktailRepository) {

    suspend fun execute(updatedCocktail: CocktailEntity) {
        cocktailRepository.updateCocktail(updatedCocktail)
    }
}