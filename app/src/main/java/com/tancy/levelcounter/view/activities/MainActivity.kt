package com.tancy.levelcounter.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tancy.levelcounter.R
import com.tancy.levelcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // direciona para a tela de cadastro
        binding.buttonAdicionar.setOnClickListener {
            var intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}