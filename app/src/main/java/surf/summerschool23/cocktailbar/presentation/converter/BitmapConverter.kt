package surf.summerschool23.cocktailbar.presentation.converter


import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream


class BitmapConverter {
    fun toByteArray(bitmap: Bitmap?): ByteArray {
        if (bitmap == null)
            return byteArrayOf()

        val blob = ByteArrayOutputStream()
        bitmap.compress(CompressFormat.PNG, 0, blob)
        return blob.toByteArray()
    }

    fun toBitmap(byteArray: ByteArray?, defaultBitmap: Bitmap): Bitmap {
        if (byteArray == null)
            return defaultBitmap

        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}