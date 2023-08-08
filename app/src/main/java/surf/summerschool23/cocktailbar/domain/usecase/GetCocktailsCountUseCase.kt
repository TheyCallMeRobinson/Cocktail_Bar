package surf.summerschool23.cocktailbar.domain.usecase

import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

class GetCocktailsCountUseCase(private val cocktailRepository: CocktailRepository) {

    suspend fun execute(): Int {
        return cocktailRepository.getCocktailsCount()
    }
}