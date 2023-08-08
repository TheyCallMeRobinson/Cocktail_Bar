package surf.summerschool23.cocktailbar.presentation.model

import android.graphics.Bitmap

data class CocktailDetailsInfo(
    val title: String,
    val description: String,
    val ingredients: String,
    val recipe: String,
    val image: Bitmap
)