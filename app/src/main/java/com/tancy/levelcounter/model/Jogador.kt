package com.tancy.levelcounter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jogadores")
class Jogador (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "nivel")
    val nivel : Int = 1,
    @ColumnInfo(name = "equipamentos")
    val equipamento : Int = 0,
    @ColumnInfo(name = "forca")
    val forca : Int = 0,
)