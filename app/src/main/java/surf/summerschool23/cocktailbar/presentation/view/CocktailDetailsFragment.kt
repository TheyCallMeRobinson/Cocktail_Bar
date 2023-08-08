package surf.summerschool23.cocktailbar.presentation.view

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.data.environment.Status
import surf.summerschool23.cocktailbar.databinding.FragmentCocktailDetailsBinding
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.presentation.converter.BitmapConverter
import surf.summerschool23.cocktailbar.presentation.viewmodel.CocktailDetailsViewModel
import surf.summerschool23.cocktailbar.presentation.viewmodel.MainViewModel

class CocktailDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCocktailDetailsBinding
    private val viewModel by viewModel<CocktailDetailsViewModel>()
    private val mainViewModel by activityViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCocktailDetailsBinding.inflate(inflater)

        setUpObservers()

        return binding.root
    }

    private fun setUpObservers() {
        viewModel.getCocktailByTitle(mainViewModel.getCurrentCocktailTitle()).observe(viewLifecycleOwner) {
            it?.let {
                when(it.status) {
                    Status.SUCCESS -> setUpViews(it.data)
                    Status.ERROR -> Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    Status.LOADING -> {}
                }
            }
        }
    }

    private fun setUpViews(cocktail: CocktailEntity?) {
        if (cocktail == null) {
            Toast.makeText(requireContext(), "Error: No data provided", Toast.LENGTH_LONG).show()
            return
        }

        binding.cocktailDetailsIv.setImageBitmap(BitmapConverter().toBitmap(cocktail.image, BitmapFactory.decodeResource(resources, R.drawable.cocktail_placeholder)))
        binding.cocktailDetailsInclude.includeDetailsCocktailInfoTitleTv.text = cocktail.title
        binding.cocktailDetailsInclude.includeDetailsCocktailInfoRecipeTv.text = cocktail.recipe
        var recipeString = ""
        if (cocktail.ingredients != null) {
            for (i in cocktail.ingredients)
                recipeString += i + "\n" // converts to StringBuilder automatically
        }
        binding.cocktailDetailsInclude.includeDetailsCocktailInfoIngredientsTv.text = recipeString
        binding.cocktailDetailsInclude.includeDetailsCocktailInfoDescriptionTv.text = cocktail.description
    }

}