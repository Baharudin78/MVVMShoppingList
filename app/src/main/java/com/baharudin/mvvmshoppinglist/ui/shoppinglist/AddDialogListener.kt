package com.baharudin.mvvmshoppinglist.ui.shoppinglist

import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingList)
}