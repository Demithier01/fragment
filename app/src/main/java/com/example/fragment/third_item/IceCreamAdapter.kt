package com.example.fragment.third_item

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.databinding.ItemThirdIceCreamBinding
import com.example.fragment.databinding.ThirdIceCreamBinding

class IceCreamAdapter (private val textList: MutableList<String>):
RecyclerView.Adapter<IceCreamAdapter.IceCreamViewHolder>(){

    class IceCreamViewHolder(private val binding: ItemThirdIceCreamBinding) : RecyclerView.ViewHolder(binding.root) {
        val text: TextView = binding.textNameIceCream
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IceCreamViewHolder {
        val binding = ItemThirdIceCreamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IceCreamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IceCreamViewHolder, position: Int) {
        val currentItem = textList[position]
        holder.text.text = currentItem
    }


    override fun getItemCount(): Int = textList.size

}