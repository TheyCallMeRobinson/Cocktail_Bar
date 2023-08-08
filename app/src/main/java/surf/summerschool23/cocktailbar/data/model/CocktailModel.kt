package surf.summerschool23.cocktailbar.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailModel(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,

    @ColumnInfo(name = "recipe")
    val recipe: String?,

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "image")
    val image: ByteArray?
)