package com.baharudin.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert (item : ShoppingList)
    @Delete
    suspend fun delete(item: ShoppingList)
    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingList(): LiveData<List<ShoppingList>>
}