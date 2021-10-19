package com.example.cadastroprodutos.ui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.Dados
import com.example.cadastroprodutos.ui.adapter.AdapterCadastro

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_cadastro.setOnClickListener(this)
    }

    override fun onResume() {
        val lista = Cadastro(applicationContext).getLista()
        recyler_view_cadastro.layoutManager=LinearLayoutManager(applicationContext)
        recyler_view_cadastro.adapter=AdapterCadastro(lista)
        super.onResume()
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.add_cadastro) {
            startActivity(Intent(this,
                CadastroActivity::class.java))
        }
    }

}