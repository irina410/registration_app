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
        binding.itemPrice.text = intent.getStringExtra("PRICE")
        binding.imageViewoftitle.setImageResource(intent.getIntExtra("IMG", 0))

    }
}