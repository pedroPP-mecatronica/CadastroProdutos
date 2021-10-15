package com.example.cadastroprodutos.ui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.Dados
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity() : AppCompatActivity(), View.OnClickListener {

    var cadastro: Cadastro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        btn_salvar.setOnClickListener(this)
        cadastro = Cadastro(applicationContext)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_salvar) {
            salvar()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun salvar() {
        //salvar um objeto da classe cadastro com suas propriedades na lista
        val nome = input_nome.text.toString()
        val precos = input_preco.text.toString()
        val descricoes = input_descricao.text.toString()
        val dados = Dados(nome, precos, descricoes)
        cadastro?.armazenarNaLista(dados)
    }

}