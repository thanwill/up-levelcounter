package com.tancy.levelcounter.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.tancy.levelcounter.R
import com.tancy.levelcounter.databinding.ActivityMainBinding
import com.tancy.levelcounter.view.adapters.JogadorAdapter
import com.tancy.levelcounter.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JogadorAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = JogadorAdapter(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setAdapter()
        setObservers()

        // direciona para a tela de cadastro
        binding.buttonAdicionar.setOnClickListener {
            var intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    fun setObservers() {
        viewModel.getListViewModel().observe(this) {
            adapter.updateJogadores(it)
        }
        viewModel.getMessage().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    fun setAdapter() {
        binding.recyclerViewJogadores.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewJogadores.adapter = adapter

        adapter.onItemLongClick = {
            viewModel.deletar(it)
        }

        adapter.onItemClick = {
            val jogador = it
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("id", jogador.id)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllJogadores()
    }
}