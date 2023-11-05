package com.tancy.levelcounter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tancy.levelcounter.model.Jogador
import com.tancy.levelcounter.model.ValidarJogador
import com.tancy.levelcounter.repository.JogadorRepository

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val message = MutableLiveData<String>()
    private val validacao = ValidarJogador()
    private val repository = JogadorRepository( application.applicationContext)

    fun getMessage() : LiveData<String> {
        return message
    }

    fun salvarJogador( nome:String, nivel: String, armadura:String, modificador:String) : Boolean {

        if(!validacao.camposEmBranco(nome, nivel, armadura, modificador)){
            message.value = "Campos não podem estar em branco!"
            return false
        }

        if (!validacao.verificaTamanho(nome, 3, 30)) {
            message.value = "Nome deve ter entre 3 e 30 caracteres!"
            return false
        }

        var jogador = Jogador(
            0,
            nome,
            nivel.toInt(),
            armadura.toInt(),
            modificador.toInt(),
            forca = nivel.toInt() + modificador.toInt() + armadura.toInt()
        )

        if(!repository.salvar(jogador)){
            message.value = "Erro ao salvar jogador!"
            return false
        }

        message.value = "Jogador salvo com sucesso!"
        return true

    }
}