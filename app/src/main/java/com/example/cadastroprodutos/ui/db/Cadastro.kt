package com.example.cadastroprodutos.ui

import android.content.Context
import com.example.cadastroprodutos.ui.db.SecurityPreferences


data class Dados(var nomes: String, var precos: String, var descricoes: String)

 class Cadastro(context: Context) {
     val preferences: SecurityPreferences = SecurityPreferences(context)

     fun armazenarNaLista(dados:Dados) {
         preferences.storeList("list", dados)
     }

     fun getLista(): List<Dados> {
         return preferences.getList("list")
     }
}