package com.example.mad_practical3_20012021053

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.mad_practical3_20012021053.databinding.ActivityLoginBinding
import com.example.mad_practical3_20012021053.databinding.ActivityUserBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class UserActivity : AppCompatActivity() {

    //    lateinit var mTextView: TextView
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        // Code for Making Navigation Bar Work :
        binding.DashboardBottomNavigationView.setOnItemSelectedListener { it1 ->
            when (it1.itemId) {
                R.id.bottom_nav_logout -> {
                    Intent(this, MainActivity::class.java).also { startActivity(it) }
                }
            }
            return@setOnItemSelectedListener true
        }

    //
//        mTextView = findViewById(R.id.userGreeting)
//
//        val loginUsername = intent
//            var user:String? = intent.getStringExtra("Username")
//
//        mTextView.text = user

    }
}