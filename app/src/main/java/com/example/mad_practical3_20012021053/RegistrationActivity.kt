package com.example.mad_practical3_20012021053

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.view.WindowCompat

import com.example.mad_practical3_20012021053.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.BottomNavigationView.selectedItemId = R.id.bottom_nav_registration
        binding.BottomNavigationView.setOnItemSelectedListener { it1 ->
            when (it1.itemId) {
                R.id.bottom_nav_registration -> {
                    Intent(this, RegistrationActivity::class.java).also { startActivity(it) }
                }

                R.id.bottom_nav_login -> {
                    Intent(this, LoginActivity::class.java).also { startActivity(it) }
                }
                R.id.bottom_nav_home -> {
                    Intent(this, MainActivity::class.java).also { startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true
        }

        // Code for Login :
        val signupText = findViewById<TextView>(R.id.login_link)
        signupText.setOnClickListener {

            // Testing !!
            Toast.makeText(this,"Login Link is Clicked", Toast.LENGTH_LONG).show()

            // Code for Opening the Login/Signin Activity
            val loginScreen = Intent(this,LoginActivity::class.java)
            startActivity(loginScreen)
        }

        // Code for Checking Username & Password :
        val registerBtnClicked = findViewById<Button>(R.id.btnRegister)

        registerBtnClicked.setOnClickListener {

            val username = findViewById<EditText>(R.id.regUsernameEditText).text.toString()
            val phone = findViewById<EditText>(R.id.regPhoneEditText).text.toString()
            val city = findViewById<EditText>(R.id.regCityEditText).text.toString()
            val email = findViewById<EditText>(R.id.regEmailEditText).text.toString()
            val password = findViewById<EditText>(R.id.regPasswordEditText).text.toString()
            val confirmpass = findViewById<EditText>(R.id.regconfirmpasswordEditText).text.toString()


            // Testing
            if(username == "" || phone == "" || city == "" || email == "" || password == "" || confirmpass == "")
            {
                Toast.makeText(this,"Please Fill out the Fields !!",Toast.LENGTH_LONG).show()

                val registerEmptyFields = Intent(this,RegistrationActivity::class.java)
                startActivity(registerEmptyFields)
            }

            else if(password != confirmpass)
            {
                Toast.makeText(this,"Registration Failed!!\nPassword Should be Same in Both Fields",Toast.LENGTH_LONG).show()

                val passwordMatchError = Intent(this,RegistrationActivity::class.java)
                startActivity(passwordMatchError)
            }

            else if(phone.length != 10){

                if(!phone.isDigitsOnly()){
                    Toast.makeText(this,"Registration Failed!!\nPhone Number should contain digits Only",Toast.LENGTH_LONG).show()

                    val phoneNotHavingDigits = Intent(this,RegistrationActivity::class.java)
                    startActivity(phoneNotHavingDigits)
                }
                else {
                    Toast.makeText(this,"Registration Failed!!\nPhone Number should have 10 digits Only",Toast.LENGTH_LONG).show()

                    val phoneLengthError = Intent(this, RegistrationActivity::class.java)
                    startActivity(phoneLengthError)
                }
            }

            else{
                Toast.makeText(this,"Registration Success!!",Toast.LENGTH_LONG).show()

                val registerSuccess = Intent(this,RegistrationActivity::class.java)
                startActivity(registerSuccess)
            }
        }
    }
}