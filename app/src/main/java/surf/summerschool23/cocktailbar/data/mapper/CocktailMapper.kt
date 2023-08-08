package surf.summerschool23.cocktailbar.data.mapper

import surf.summerschool23.cocktailbar.data.model.CocktailModel
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity

class CocktailMapper {

    fun toEntity(cocktailModel: CocktailModel): CocktailEntity {
        return CocktailEntity(
            title = cocktailModel.title,
            description = cocktailModel.description ?: "",
            ingredients = ArrayList(),
            recipe = cocktailModel.recipe ?: ""
        )
    }

    fun toDBModel(cocktailEntity: CocktailEntity): CocktailModel {
        return CocktailModel(
            title = cocktailEntity.title,
            description = cocktailEntity.description ?: "",
            ingredients = cocktailEntity.ingredients ?: ArrayList(),
            recipe = cocktailEntity.recipe ?: ""
        )
    }
}