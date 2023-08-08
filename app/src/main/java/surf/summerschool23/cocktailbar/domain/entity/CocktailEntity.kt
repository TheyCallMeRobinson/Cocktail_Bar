package surf.summerschool23.cocktailbar.domain.entity

data class CocktailEntity(
    val title: String,
    val description: String?,
    val ingredients: List<String>?,
    val recipe: String?,
    val image: ByteArray?
)