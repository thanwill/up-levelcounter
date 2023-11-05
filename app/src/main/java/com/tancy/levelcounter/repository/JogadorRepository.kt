package com.tancy.levelcounter.repository

import android.content.Context
import com.tancy.levelcounter.model.Jogador

class JogadorRepository (context: Context) {

    val dao = AppDatabase.getInstance(context).jogadorDao()

    fun salvar(jogador: Jogador) : Boolean{
        return dao.salvar(jogador) > 0
    }

    fun atualizar(jogador: Jogador) {
        dao.atualizar(jogador)
    }

    fun deletar(jogador: Jogador) {
        dao.deletar(jogador)
    }

    fun selecionarTodos(): List<Jogador> {
        return dao.selecionarTodos()
    }

    fun selecionarPorId(id: Int): Jogador {
        return dao.selecionarPorId(id)
    }
}