package com.example.cadastroprodutos.ui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.databinding.ActivityCadastroBinding
import com.example.cadastroprodutos.databinding.ActivityMainBinding
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.Dados
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity() : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCadastroBinding
    var cadastro: Cadastro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btn_salvar?.setOnClickListener(this)
        cadastro = Cadastro(applicationContext)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_salvar) {
            salvar()
            finish()
        }
    }

    private fun salvar() {
        //salvar um objeto da classe cadastro com suas propriedades na lista
        val nome = binding.inputNome.text.toString()
        val precos = binding.inputPreco.text.toString()
        val descricoes = binding.inputDescricao.text.toString()
        val dados = Dados(nome, precos, descricoes)
        cadastro?.armazenarNaLista(dados)
    }

}