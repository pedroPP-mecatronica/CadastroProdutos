package com.example.cadastroprodutos.ui.db

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.cadastroprodutos.ui.Dados
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type


class SecurityPreferences(context: Context) {

    val mSharedPreference: SharedPreferences =
        context.getSharedPreferences("db", Context.MODE_PRIVATE)

    fun storeList(key: String, value: Dados) {
        val listaDados = getList("list")
        listaDados.add(value)
        this.mSharedPreference.edit().putString(key, Gson().toJson(listaDados)).apply()
    }

    fun getList(key: String): MutableList<Dados> {
        val json = this.mSharedPreference.getString(key, "")

        val type: Type = object : TypeToken<MutableList<Dados?>?>() {}.type

        val objeto = Gson().fromJson<MutableList<Dados>>(json, type)
        return objeto?.asReversed() ?: mutableListOf()
    }

    fun clearElement( adapterPosition: Int) {
        val listaDados=getList("list")
        listaDados.removeAt(adapterPosition)
        this.mSharedPreference.edit().putString("list", Gson().toJson(listaDados)).apply()
        Log.d("teste", "lista de dados: " + listaDados)
    }
}