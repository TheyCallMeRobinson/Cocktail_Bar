package surf.summerschool23.cocktailbar.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.databinding.FragmentCreateCocktailBinding

class CreateCocktailFragment : Fragment() {

    private lateinit var binding: FragmentCreateCocktailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateCocktailBinding.inflate(inflater)

        binding.createCocktailAddPhotoIv.clipToOutline = true

        return binding.root
    }

}