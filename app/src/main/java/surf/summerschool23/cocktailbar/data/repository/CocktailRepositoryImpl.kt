package surf.summerschool23.cocktailbar.data.repository

import surf.summerschool23.cocktailbar.data.db.CocktailDAO
import surf.summerschool23.cocktailbar.data.mapper.CocktailMapper
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.domain.repository.CocktailRepository

class CocktailRepositoryImpl(
    private val cocktailDAO: CocktailDAO,
    private val cocktailMapper: CocktailMapper
) : CocktailRepository {

    override suspend fun getAllCocktails(): List<CocktailEntity> {
        return cocktailDAO.getAll().map { cocktailMapper.toEntity(it) }.toList()
    }

    override suspend fun getCocktailsCount(): Int {
        return cocktailDAO.getCountAll()
    }

    override suspend fun updateCocktail(updatedCocktail: CocktailEntity) {
        cocktailDAO.updateCocktail(cocktailMapper.toDBModel(updatedCocktail))
    }

    override suspend fun createNewCocktail(newCocktail: CocktailEntity) {
        cocktailDAO.createNewCocktail(cocktailMapper.toDBModel(newCocktail))
    }


}