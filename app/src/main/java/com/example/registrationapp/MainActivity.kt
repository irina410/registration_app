package com.example.registrationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.registrationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //---  binding  ---
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //----------------------


        //--  made an animation background  ----
        val constraintLayout: ConstraintLayout = findViewById(R.id.main_layout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable

        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        //------------------------------------



        binding.buttonReg.setOnClickListener{

            //-----------------------------------------

            val userLogin = binding.userLoginEditText.text.toString().trim()
            val userEmail = binding.userEmailEditText.text.toString().trim()
            val userPass = binding.userPassEditText.text.toString().trim()

            //-----------------------------------------


            if (userLogin == "" || userEmail == "" || userPass == ""){
                Toast.makeText(this, "Невсе поля заполнены", Toast.LENGTH_LONG).show()
            }else{
                val user = User(userLogin, userEmail, userPass)
                
                val db = DBHelper(this, null)
                db.addUser(user)

                Toast.makeText(this, "Пользователь $userLogin добавлен", Toast.LENGTH_LONG).show()

                binding.userLoginEditText.text.clear()
                binding.userEmailEditText.text.clear()
                binding.userPassEditText.text.clear()
            }

        }


        binding.textAuth.setOnClickListener{
            startActivity(Intent(this,AuthActivity::class.java))
        }


    }
}