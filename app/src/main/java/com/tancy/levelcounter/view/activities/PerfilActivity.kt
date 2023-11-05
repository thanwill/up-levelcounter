package com.tancy.levelcounter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.tancy.levelcounter.R
import com.tancy.levelcounter.databinding.ActivityPerfilBinding
import com.tancy.levelcounter.model.Jogador
import com.tancy.levelcounter.viewmodel.PerfilViewModel

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding
    private lateinit var viewModel: PerfilViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)
        setObservers()

        val id = intent.getIntExtra("id", 0)

        if (id == 0) {
            finish()
        }else{
            viewModel.getJogador(id)
        }

    }

    fun setObservers() {
        viewModel.getJogador().observe(this) {
            binding.textViewNome.text = it.nome
            // nivel, armadura e modificador
            binding.textViewForca.text = it.forca.toString()
            binding.textViewArmadura.text = it.armadura.toString()
            binding.textViewModificador.text = it.modificador.toString()
        }

        viewModel.getMessage().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}