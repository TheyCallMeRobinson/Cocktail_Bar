package surf.summerschool23.cocktailbar.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.data.environment.Resource
import surf.summerschool23.cocktailbar.data.environment.Status
import surf.summerschool23.cocktailbar.databinding.FragmentMyCocktailsBlankBinding
import surf.summerschool23.cocktailbar.presentation.viewmodel.MyCocktailsBlankViewModel

class MyCocktailsBlankFragment : Fragment() {

    private lateinit var binding: FragmentMyCocktailsBlankBinding
    private val viewModel by viewModel<MyCocktailsBlankViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCocktailsBlankBinding.inflate(inflater)

        binding.myCocktailsBlankAddNewCocktailFab.setOnClickListener{
            findNavController().navigate(R.id.action_myCocktailsBlankFragment_to_createCocktailFragment)
        }

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.getCocktailsCount().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when(resource.status) {
                    Status.SUCCESS -> decideActionByCocktailsCount(resource.data ?: 0)
                    Status.ERROR -> Toast.makeText(requireContext(), resource.message, Toast.LENGTH_LONG).show()
                    Status.LOADING -> {
                        binding.myCocktailsBlankArrowIv.visibility = View.INVISIBLE
                        binding.myCocktailsBlankAddNewCocktailFab.visibility = View.INVISIBLE
                        binding.myCocktailsBlankAddCocktailTv.visibility = View.INVISIBLE
                        binding.myCocktailsBlankProgressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun decideActionByCocktailsCount(cocktailsCount: Int) {
        if (cocktailsCount > 0) {
            findNavController().navigate(R.id.action_myCocktailsBlankFragment_to_myCocktailsFragment)
        } else {
            binding.myCocktailsBlankArrowIv.visibility = View.VISIBLE
            binding.myCocktailsBlankAddNewCocktailFab.visibility = View.VISIBLE
            binding.myCocktailsBlankAddCocktailTv.visibility = View.VISIBLE
            binding.myCocktailsBlankProgressBar.visibility = View.INVISIBLE
        }
    }

}