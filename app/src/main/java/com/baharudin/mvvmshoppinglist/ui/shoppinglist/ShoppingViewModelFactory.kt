package com.baharudin.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baharudin.mvvmshoppinglist.data.repository.ShoppingRepository


@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private var repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository)as T
    }

}