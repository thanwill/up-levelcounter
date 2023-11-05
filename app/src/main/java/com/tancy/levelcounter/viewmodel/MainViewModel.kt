package com.tancy.levelcounter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tancy.levelcounter.model.Jogador
import com.tancy.levelcounter.repository.JogadorRepository

class MainViewModel (application: Application): AndroidViewModel(application) {

    private var repository = JogadorRepository(application.applicationContext)
    private var listViewModel = MutableLiveData<List<Jogador>>()
    private var message = MutableLiveData<String>()

    fun getListViewModel() : LiveData<List<Jogador>> {
        return listViewModel
    }

    fun getMessage() : LiveData<String> {
        return message
    }

    fun getAllJogadores() {
        listViewModel.value = repository.selecionarTodos()
    }

    fun deletar( jogador: Jogador){
        repository.deletar(jogador)
        message.value = "Jogador deletado com sucesso!"
    }

}