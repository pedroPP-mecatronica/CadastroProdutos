package com.example.cadastroprodutos.ui.db

import android.content.Context
import android.content.SharedPreferences
import com.example.cadastroprodutos.ui.Dados
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type


class SecurityPreferences(context: Context) {

    val mSharedPreference: SharedPreferences = context.getSharedPreferences("db", Context.MODE_PRIVATE)

    fun storeList(key: String, value: Dados) {
        val listaDados = getList("list").toMutableList()
        listaDados.add(value)
        this.mSharedPreference.edit().putString(key, Gson().toJson(listaDados)).apply()
    }

    fun getList(key: String): List<Dados> {
        val json = this.mSharedPreference.getString(key, "")

        val type: Type = object : TypeToken<List<Dados?>?>() {}.type

        val objeto = Gson().fromJson<List<Dados>>(json, type)
        return objeto ?: listOf()
    }
}