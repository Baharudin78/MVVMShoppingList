package com.baharudin.mvvmshoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.mvvmshoppinglist.R
import com.baharudin.mvvmshoppinglist.data.db.ShoppingDatabase
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList
import com.baharudin.mvvmshoppinglist.data.repository.ShoppingRepository
import com.baharudin.mvvmshoppinglist.other.ShoppingAdapter

import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(),viewModel)

        rv_item.layoutManager = LinearLayoutManager(this)
        rv_item.adapter = adapter

        viewModel.getAllShoppingList().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            ShoppingAddDialog(
                this,object : AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingList) {
                        viewModel.upsert(item)
                    }
                }
            ).show()
        }
    }
}