package com.tancy.levelcounter.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tancy.levelcounter.R
import com.tancy.levelcounter.model.Jogador

class JogadorAdapter (context: Context): RecyclerView.Adapter<JogadorViewHolder>() {

    lateinit var jogadores: List<Jogador>
    var onItemLongClick : ((Jogador) -> Unit)? = null
    var onItemClick : ((Jogador) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadorViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.personagem_layout, parent, false)
        return JogadorViewHolder(layout)
    }

    override fun onBindViewHolder(holder: JogadorViewHolder, position: Int) {
        val jogador = jogadores[position]
        holder.nome.text = jogador.nome

        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(jogador)
            true
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(jogador)
        }
    }

    override fun getItemCount(): Int {
        return jogadores.size
    }

    fun updateJogadores(jogadores: List<Jogador>) {
        this.jogadores = jogadores
        notifyDataSetChanged()
    }
}