package com.tancy.levelcounter.view.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tancy.levelcounter.R

class JogadorViewHolder (layout: View): RecyclerView.ViewHolder(layout) {
    var nome = layout.findViewById<TextView>(R.id.textViewNomeJogador)
}