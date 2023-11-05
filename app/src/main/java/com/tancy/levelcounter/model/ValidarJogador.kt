package com.tancy.levelcounter.model

class ValidarJogador {

    fun verificaTamanho(nome:String, minimo:Int, maximo:Int): Boolean {
        return nome.length in minimo..maximo
    }

    fun camposEmBranco(nome:String, nivel:String, armadura:String, modificador:String): Boolean {
        return nome.isNotBlank() && nivel.isNotBlank() && armadura.isNotBlank() && modificador.isNotBlank()
    }


}