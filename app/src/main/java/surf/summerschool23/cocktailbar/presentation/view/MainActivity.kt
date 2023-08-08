package surf.summerschool23.cocktailbar.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import surf.summerschool23.cocktailbar.R
import surf.summerschool23.cocktailbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}