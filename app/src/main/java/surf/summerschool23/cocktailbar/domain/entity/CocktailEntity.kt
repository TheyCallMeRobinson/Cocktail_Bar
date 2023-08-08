package surf.summerschool23.cocktailbar.domain.entity

data class CocktailEntity(
    val title: String,
    val description: String?,
    val ingredients: ArrayList<String>?,
    val recipe: String?,
    val image: ByteArray?
)