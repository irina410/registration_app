package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registrationapp.databinding.ActivityAuthBinding
import com.example.registrationapp.databinding.ActivityMainBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //---  binding  ---
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //----------------------

        binding.textVReg.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))

        }



        binding.buttonLogin.setOnClickListener{

            //-----------------------------------------

            val userLogin = binding.userLoginEditTextAuth.text.toString().trim()
            val userPass = binding.userPassEditTextAuth.text.toString().trim()

            //-----------------------------------------


            if (userLogin == "" || userPass == ""){
                Toast.makeText(this, "Невсе поля заполнены", Toast.LENGTH_LONG).show()
            }else{
                val db = DBHelper(this, null)
                val isAuth = db.getUser(userLogin, userPass)

                if (isAuth){
                    Toast.makeText(this, "Пользователь $userLogin авторизован", Toast.LENGTH_LONG).show()
                    binding.userPassEditTextAuth.text.clear()
                    binding.userLoginEditTextAuth.text.clear()

                    startActivity(Intent(this,ItemActivity ::class.java))

                }else{
                    Toast.makeText(this, "чьтото не так(", Toast.LENGTH_LONG).show()

                }





            }

        }


    }
}