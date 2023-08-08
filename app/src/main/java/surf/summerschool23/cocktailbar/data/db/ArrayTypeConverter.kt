package surf.summerschool23.cocktailbar.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ArrayTypeConverter {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<String?>?>() {}.type)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String {
        return Gson().toJson(list)
    }
}