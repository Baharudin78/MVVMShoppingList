package com.baharudin.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.baharudin.mvvmshoppinglist.R
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList
import kotlinx.android.synthetic.main.add_shopping_list.*

class ShoppingAddDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_shopping_list)

        Add.setOnClickListener {
            val name = et_name.text.toString()
            val jumlah = et_amount.text.toString().toInt()

            if (name.isEmpty() && jumlah.equals(0)){
                et_name.error = "please give a value"
                et_amount.error = "please give a amount"
                return@setOnClickListener
            }
//            if (name.isNullOrEmpty() ){
//                Toast.makeText(context,"Please fill the form !!" , Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//
//            }

            val item = ShoppingList(name,jumlah)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        cancel.setOnClickListener {
            cancel()
        }

        
    }

}