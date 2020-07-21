package com.baharudin.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Shopping_item")
data class ShoppingList(
    @ColumnInfo(name = "item_name")
    var name : String,
    @ColumnInfo(name = "item_amount")
    var amount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}