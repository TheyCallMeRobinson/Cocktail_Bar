package surf.summerschool23.cocktailbar.presentation.view

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.data.environment.Status
import surf.summerschool23.cocktailbar.databinding.FragmentMyCocktailsBinding
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.presentation.adapter.CocktailListAdapter
import surf.summerschool23.cocktailbar.presentation.viewmodel.MyCocktailsViewModel

class MyCocktailsFragment : Fragment() {

    private lateinit var binding: FragmentMyCocktailsBinding
    private val viewModel by viewModel<MyCocktailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCocktailsBinding.inflate(inflater)

        binding.myCocktailsAddNewCocktailFab.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktailsFragment_to_createCocktailFragment)
        }

        setUpObservers()

        return binding.root
    }

    private fun setUpObservers() {
        viewModel.getAllCocktailsList().observe(viewLifecycleOwner) {
            it?.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        binding.myCocktailsProgressBar.visibility = View.INVISIBLE
                        setCocktailsList(it.data!!)
                    }
                    Status.ERROR -> {
                        binding.myCocktailsProgressBar.visibility = View.INVISIBLE
                        Toast.makeText(
                            requireContext(),
                            "Error while loading cocktails list",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    Status.LOADING -> binding.myCocktailsProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setCocktailsList(cocktailsList: List<CocktailEntity>) {
        val cocktailsListAdapter = CocktailListAdapter(
            cocktailsList, BitmapFactory.decodeResource(resources, R.drawable.cocktail_placeholder)
        )
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        binding.myCocktailsListRv.apply {
            layoutManager = gridLayoutManager
            adapter = cocktailsListAdapter
            setHasFixedSize(true)
        }
    }


}