package com.example.cadastroprodutos.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.Dados
import com.example.cadastroprodutos.ui.db.SecurityPreferences
import kotlinx.android.synthetic.main.item_cadastrado.view.*

class AdapterCadastro(val cadastros: MutableList<Dados>) :
    RecyclerView.Adapter<AdapterCadastro.CadastroViewHolder>() {

    inner class CadastroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(cadastro: Dados) {
            with(cadastro) {
                itemView.edit_nome.text = nomes
                itemView.edit_preco.text = precos
                itemView.edit_descricao.text = descricoes
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CadastroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cadastrado, parent, false)
        return CadastroViewHolder(view)
    }

    override fun onBindViewHolder(holder: CadastroViewHolder, position: Int) {
        val objeto = cadastros[position]
        holder.bind(objeto)
    }

    override fun getItemCount(): Int {
        return cadastros.size
    }

}