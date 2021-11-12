package com.example.cadastroprodutos.ui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroprodutos.R
import com.example.cadastroprodutos.databinding.ActivityMainBinding
import com.example.cadastroprodutos.ui.Cadastro
import com.example.cadastroprodutos.ui.adapter.AdapterCadastro
import com.example.cadastroprodutos.ui.db.SecurityPreferences
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterCadastro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        add_cadastro?.setOnClickListener(this)
    }

    override fun onResume() {
        val lista = Cadastro(applicationContext).getLista()
        adapter = AdapterCadastro(lista)
        recyler_view_cadastro.layoutManager = LinearLayoutManager(applicationContext)
        recyler_view_cadastro.adapter = adapter
        super.onResume()
        val helper =
            ItemTouchHelper(ItemTouchHelper(0, androidx.recyclerview.widget.ItemTouchHelper.LEFT))
        helper.attachToRecyclerView(recyler_view_cadastro)

    }

    inner class ItemTouchHelper(dragDirs: Int, swipeDirs: Int) :
        androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val from: Int = viewHolder.adapterPosition
            val to: Int = target.adapterPosition
            Collections.swap(adapter.cadastros, from, to)
            adapter.notifyItemMoved(from, to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.cadastros.removeAt(viewHolder.adapterPosition)
            SecurityPreferences(applicationContext).clearElement(viewHolder.adapterPosition)
            adapter.notifyItemRemoved(viewHolder.adapterPosition)
        }
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.add_cadastro) {
            startActivity(
                Intent(
                    this,
                    CadastroActivity::class.java
                )
            )
        }
    }

}