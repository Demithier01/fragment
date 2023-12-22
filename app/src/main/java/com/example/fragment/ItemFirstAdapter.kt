package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.Model.First

class ItemFirstAdapter(private val itemList:List<First>) :
RecyclerView.Adapter<ItemFirstAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView =itemView.findViewById(R.id.imgView)
        val textView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_first,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.img.setImageResource(itemList[position].img)
        holder.textView.text = itemList[position].name
    }
}