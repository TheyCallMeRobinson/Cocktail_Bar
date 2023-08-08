package surf.summerschool23.cocktailbar.presentation.adapter

import android.content.res.Resources
import surf.summerschool23.cocktailbar.R
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.presentation.converter.BitmapConverter

class CocktailListAdapter(
    private val cocktailsList: List<CocktailEntity>,
    private val defaultBitmap: Bitmap,
    private val onClickListener: (CocktailEntity) -> Unit
) : RecyclerView.Adapter<CocktailListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cocktail_brief, parent, false)

        return ViewHolder(view) {onClickListener(cocktailsList[it])}
    }

    override fun getItemCount() = cocktailsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listElement = cocktailsList[position]
        val bitmapConverter = BitmapConverter()

        holder.title.text = listElement.title
        holder.image.setImageBitmap(bitmapConverter.toBitmap(listElement.image, defaultBitmap))
        holder.image.clipToOutline = true
    }

    class ViewHolder(
        val view: View,
        val onViewClickListener: (Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.item_cocktail_brief_iv)
        val title: TextView = view.findViewById(R.id.item_cocktail_brief_title_tv)

        init {
            view.setOnClickListener {
                onViewClickListener(adapterPosition)
            }
            view.isClickable = true
        }
    }
}