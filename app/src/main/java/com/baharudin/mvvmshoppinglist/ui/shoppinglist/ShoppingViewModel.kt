package com.baharudin.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList
import com.baharudin.mvvmshoppinglist.data.repository.ShoppingRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel(){
    fun upsert(item : ShoppingList) = GlobalScope.launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingList) = GlobalScope.launch {
        repository.delete(item)
    }
    fun getAllShoppingList() = repository.getAllDataShoppingItems()

}