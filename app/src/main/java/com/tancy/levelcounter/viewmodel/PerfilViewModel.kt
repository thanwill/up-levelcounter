package com.tancy.levelcounter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.tancy.levelcounter.model.Jogador
import com.tancy.levelcounter.model.ValidarJogador
import com.tancy.levelcounter.repository.JogadorRepository

class PerfilViewModel (application: Application) : AndroidViewModel(application) {
    private var repository = JogadorRepository(application.applicationContext)
    private var validacao = ValidarJogador()
    private var jogadores = MutableLiveData<Jogador>()
    private var message = MutableLiveData<String>()


    fun getJogador(): MutableLiveData<Jogador> {
        return jogadores
    }

    fun getMessage(): MutableLiveData<String> {
        return message
    }

    fun getJogador(id: Int) {
        jogadores.value = repository.selecionarPorId(id)
    }




}