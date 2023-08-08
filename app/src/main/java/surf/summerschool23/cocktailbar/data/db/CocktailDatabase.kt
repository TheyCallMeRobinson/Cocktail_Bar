package surf.summerschool23.cocktailbar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import surf.summerschool23.cocktailbar.data.model.CocktailModel

@Database(
    entities = [CocktailModel::class],
    version = 1
)
@TypeConverters(ArrayTypeConverter::class)
abstract class CocktailDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDAO
}