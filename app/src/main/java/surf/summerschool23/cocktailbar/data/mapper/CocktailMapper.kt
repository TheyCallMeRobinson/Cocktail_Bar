package surf.summerschool23.cocktailbar.data.mapper

import surf.summerschool23.cocktailbar.data.model.CocktailModel
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity

class CocktailMapper {

    fun toEntity(cocktailModel: CocktailModel?): CocktailEntity? {
        if (cocktailModel == null)
            return null

        return CocktailEntity(
            title = cocktailModel.title,
            description = cocktailModel.description ?: "",
            ingredients = ArrayList(),
            recipe = cocktailModel.recipe ?: "",
            image = cocktailModel.image
        )
    }

    fun toDbModel(cocktailEntity: CocktailEntity?): CocktailModel? {
        if (cocktailEntity == null)
            return null

        return CocktailModel(
            title = cocktailEntity.title,
            description = cocktailEntity.description ?: "",
            ingredients = cocktailEntity.ingredients ?: ArrayList(),
            recipe = cocktailEntity.recipe ?: "",
            image = cocktailEntity.image
        )
    }
}