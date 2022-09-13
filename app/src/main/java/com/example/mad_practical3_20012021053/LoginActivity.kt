package com.example.mad_practical3_20012021053

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.mad_practical3_20012021053.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }
}