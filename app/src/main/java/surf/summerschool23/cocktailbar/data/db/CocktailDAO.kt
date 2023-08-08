package surf.summerschool23.cocktailbar.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import surf.summerschool23.cocktailbar.data.model.CocktailModel

@Dao
interface CocktailDAO {

    @Query("SELECT * FROM cocktails")
    suspend fun getAll(): List<CocktailModel>

    @Query("SELECT COUNT(*) FROM cocktails")
    suspend fun getCountAll(): Int

    @Update
    suspend fun updateCocktail(updatedCocktail: CocktailModel)

    @Insert
    suspend fun createNewCocktail(newCocktail: CocktailModel)
}