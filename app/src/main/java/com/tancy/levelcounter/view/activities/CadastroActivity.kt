package com.tancy.levelcounter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tancy.levelcounter.R
import com.tancy.levelcounter.databinding.ActivityCadastroBinding
import com.tancy.levelcounter.viewmodel.CadastroViewModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var cadastro : CadastroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textForcaAtual.text = "0"

        // inicializar o cadastroViewModel
        cadastro = CadastroViewModel(application)

        setObservers()

        binding.buttonCadastrar.setOnClickListener {
            val nome = binding.editTextNome.text.toString()
            val nivel = binding.editTextNivel.text.toString()
            val armadura = binding.editTextArmaduras.text.toString()
            val modificador = binding.editTextModificador.text.toString()

            // se algum campo estiver em branco, não salva e mostra mensagem de erro

            if(cadastro.salvarJogador(nome, nivel, armadura, modificador)){
                finish()
            }

        }
    }

    fun setObservers() {
        cadastro.getMessage().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }


}