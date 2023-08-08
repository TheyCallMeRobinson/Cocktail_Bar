package surf.summerschool23.cocktailbar.domain.repository

import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity

interface CocktailRepository {

    suspend fun getAllCocktails(): List<CocktailEntity>
    suspend fun getCocktailsCount(): Int
    suspend fun updateCocktail(updatedCocktail: CocktailEntity)
    suspend fun createNewCocktail(newCocktail: CocktailEntity)
    suspend fun getByTitle(title: String): CocktailEntity
}