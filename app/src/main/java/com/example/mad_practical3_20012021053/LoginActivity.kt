package com.example.mad_practical3_20012021053

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.mad_practical3_20012021053.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Code for Making Navigation Bar Work :
        binding.BottomNavigationView.selectedItemId = R.id.bottom_nav_login
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

        // Code for Sign Up Link :
        val signupText = findViewById<TextView>(R.id.signup_link)
        signupText.setOnClickListener {
            // Testing !!
            Toast.makeText(this,"Signup Link is Clicked",Toast.LENGTH_LONG).show()

            // Code for Opening the Registration/Signup Activity
            var signupScreen = Intent(this,RegistrationActivity::class.java)
            startActivity(signupScreen)
        }

        // Code for Checking Username & Password :

        mEditText = findViewById(R.id.loginUserEditText)

        val loginBtnClicked = findViewById<Button>(R.id.btnLogin)
        val username = mEditText.text.toString()
        val password = findViewById<EditText>(R.id.loginPasswordEditText).text.toString()

        loginBtnClicked.setOnClickListener {
            // Testing
            if (username==password){
                Toast.makeText(this,"Login Successfully !!",Toast.LENGTH_LONG).show()

                var loginedUserScreen = Intent(this,UserActivity::class.java)
//                loginedUserScreen.putExtra("Username",username)
                startActivity(loginedUserScreen)
            }
        }

    }
}