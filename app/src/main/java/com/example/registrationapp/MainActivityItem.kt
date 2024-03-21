package com.example.registrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationapp.databinding.ActivityMainItemBinding

private lateinit var binding: ActivityMainItemBinding
class MainActivityItem : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //---  binding  ---
        binding = ActivityMainItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //----------------------


        binding.name.text = intent.getStringExtra("NAME")
        binding.itemDesc.text = intent.getStringExtra("DESC")
        binding.itemPrice.text = "стоит " + intent.getStringExtra("PRICE") + "деняк"
        var imgName = intent.getStringExtra("IMG")
        var imgId = resources.getIdentifier(imgName, "drawable", packageName)
        binding.imageViewoftitle.setImageResource(imgId)
    }
}