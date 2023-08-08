package surf.summerschool23.cocktailbar.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.databinding.FragmentCreateCocktailBinding
import surf.summerschool23.cocktailbar.domain.entity.CocktailEntity
import surf.summerschool23.cocktailbar.presentation.converter.BitmapConverter
import surf.summerschool23.cocktailbar.presentation.viewmodel.CreateCocktailViewModel

class CreateCocktailFragment : Fragment() {

    private lateinit var binding: FragmentCreateCocktailBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val viewModel by viewModel<CreateCocktailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateCocktailBinding.inflate(inflater)

        binding.createCocktailAddPhotoIv.clipToOutline = true

        registerResult()
        setListeners()

        return binding.root
    }

    private fun validateFields(): Boolean {
        if (binding.createCocktailTitleEt.text.isNullOrBlank()) {
            binding.createCocktailTitleTil.error = "Add Title"
            return false
        }

        return true
    }

    private fun setListeners() {
        binding.createCocktailSaveBtn.setOnClickListener{
            if (validateFields()) {
                val cocktailEntity = CocktailEntity(
                    title = binding.createCocktailTitleEt.text.toString(),
                    description = binding.createCocktailDescriptionEt.text.toString(),
                    recipe = binding.createCocktailRecipeEt.text.toString(),
                    image = BitmapConverter().toByteArray(
                        binding.createCocktailAddPhotoIv.drawable.toBitmap()
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

        binding.createCocktailAddPhotoIv.setOnClickListener {
            pickImage()
        }
    }

    private fun pickImage() {
        val intent: Intent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent = Intent(MediaStore.ACTION_PICK_IMAGES)
        } else {
            intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
        }

        resultLauncher.launch(intent)
    }

    private fun registerResult() {
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            try {
                val uri: Uri? = result.data?.data
                binding.createCocktailAddPhotoIv.setImageURI(uri)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "No image was picked", Toast.LENGTH_LONG).show()
            }
        }
    }

}