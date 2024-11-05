package com.example.tugas_recycleview


import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_recycleview.databinding.ActivityMainBinding
import com.example.tugas_recycleview.databinding.ItemDisasterBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generatedataDummy()) {
                disaster ->
            Toast.makeText(this@MainActivity, "You click on pict",
                Toast.LENGTH_SHORT).show()

        }
        with(binding){
            rvDisaster.apply {
                adapter = adapterDisaster
//                layoutInflater = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
    fun generatedataDummy() : List<Disaster> {
        return listOf(
            Disaster(imageResId = R.drawable.gambar1, imageResId2 = R.drawable.gambar2),
            Disaster(imageResId = R.drawable.gambar2, imageResId2 = R.drawable.gambar3),
            Disaster(imageResId = R.drawable.gambar1, imageResId2 = R.drawable.gambar3),
            Disaster(imageResId = R.drawable.gambar1, imageResId2 = R.drawable.gambar2),
            Disaster(imageResId = R.drawable.gambar2, imageResId2 = R.drawable.gambar3),
            Disaster(imageResId = R.drawable.gambar1, imageResId2 = R.drawable.gambar3)
        )
    }
}