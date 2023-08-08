package surf.summerschool23.cocktailbar.domain.usecase

import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

class GetAllCocktailsUseCase(private val cocktailRepository: CocktailRepository) {

    suspend fun execute(): List<CocktailEntity> {
        return cocktailRepository.getAllCocktails()
    }
}