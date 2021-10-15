package com.example.cadastroprodutos.ui.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.db.SecurityPreferences

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_cadastro.setOnClickListener(this)



    }

    override fun onResume() {
        val lista = Cadastro(applicationContext).getLista()
        Toast.makeText(applicationContext, lista.toString(), Toast.LENGTH_SHORT).show()
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