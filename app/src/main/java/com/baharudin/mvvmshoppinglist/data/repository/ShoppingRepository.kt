package com.baharudin.mvvmshoppinglist.data.repository

import com.baharudin.mvvmshoppinglist.data.db.ShoppingDatabase
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList

class ShoppingRepository (
    private val db : ShoppingDatabase
){
    suspend fun upsert(item : ShoppingList) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingList) = db.getShoppingDao().delete(item)
    fun getAllDataShoppingItems() = db.getShoppingDao().getAllShoppingList()
}