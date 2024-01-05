package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragment.Model.First
import com.example.fragment.databinding.ItemFirstBinding

class ItemFirstAdapter(private val itemList:List<First>) :
RecyclerView.Adapter<ItemFirstAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(private val binding: ItemFirstBinding) : RecyclerView.ViewHolder(binding.root){
        val img : ImageView = binding.imgView
        val textView : TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val binding = ItemFirstBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem =itemList[position]
        holder.textView.text = itemList[position].name
        Glide.with(holder.itemView.context)
            .load(currentItem.imgUrl) //โหลดภาพจากurl ที่กำหนดใน currentItem
            .into(holder.img) //แสดงภาพที่โหลด
    }
}