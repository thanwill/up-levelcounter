package com.tancy.levelcounter.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tancy.levelcounter.model.Jogador

@Dao
interface JogadorDao {

    @Insert
    fun salvar(jogador: Jogador) : Long

    @Update
    fun atualizar(jogador: Jogador)

    @Delete
    fun deletar(jogador: Jogador)

    @Query("SELECT * FROM jogadores")
    fun selecionarTodos(): List<Jogador>

    @Query("SELECT * FROM jogadores WHERE id = :id")
    fun selecionarPorId(id: Int): Jogador
}