package com.baharudin.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.mvvmshoppinglist.R
import com.baharudin.mvvmshoppinglist.data.db.entities.ShoppingList
import com.baharudin.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_items.view.*

class ShoppingAdapter(
    var list : List<ShoppingList>,
    private var viewmodel : ShoppingViewModel
): RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>(){


    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.shopping_items,parent,false)
        return ShoppingViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int){
        val curlShopping = list[position]
        holder.itemView.tv_name.text = curlShopping.name
        holder.itemView.tv_amount.text = "${curlShopping.amount}"

        holder.itemView.ic_delete.setOnClickListener {
            viewmodel.delete(curlShopping)
        }

        holder.itemView.ic_plus.setOnClickListener {
            curlShopping.amount++
            viewmodel.upsert(curlShopping)
        }

        holder.itemView.ic_minus.setOnClickListener {
            if (curlShopping.amount > 0){
                curlShopping.amount--
                viewmodel.upsert(curlShopping)
            }
        }
    }
}