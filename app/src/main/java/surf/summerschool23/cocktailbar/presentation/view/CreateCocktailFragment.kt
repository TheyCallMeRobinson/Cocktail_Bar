package surf.summerschool23.cocktailbar.presentation.view

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.findNavController
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.databinding.FragmentCreateCocktailBinding
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.presentation.converter.BitmapConverter
import surf.summerschool23.cocktailbar.presentation.viewmodel.CreateCocktailViewModel

class CreateCocktailFragment : Fragment() {

    private lateinit var binding: FragmentCreateCocktailBinding
    private val viewModel by viewModel<CreateCocktailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateCocktailBinding.inflate(inflater)

        binding.createCocktailAddPhotoIv.clipToOutline = true

        binding.createCocktailSaveBtn.setOnClickListener{
            if (validateFields()) {
                val cocktailEntity = CocktailEntity(
                    title = binding.createCocktailTitleEt.text.toString(),
                    description = binding.createCocktailDescriptionEt.text.toString(),
                    recipe = binding.createCocktailRecipeEt.text.toString(),
                    image = BitmapConverter().toByteArray(
                        BitmapFactory.decodeResource(requireContext().resources,
                        R.drawable.cocktail_placeholder)
                    ),
                    ingredients = ArrayList()
                )
                viewModel.saveNewCocktail(cocktailEntity)
                findNavController().navigate(R.id.action_createCocktailFragment_to_myCocktailsFragment)
            }
        }

        binding.createCocktailCancelBtn.setOnClickListener{
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun validateFields(): Boolean {
        if (binding.createCocktailTitleEt.text.isNullOrBlank()) {
            binding.createCocktailTitleTil.error = "Add Title"

            return false
        }
        return true
    }

}