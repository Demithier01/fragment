package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragment.Model.Second
import com.example.fragment.databinding.ItemSecondBinding

class ItemSecondAdapter(private var secondList: List<Second>):
    RecyclerView.Adapter<ItemSecondAdapter.SecondViewHolder>() {
        class SecondViewHolder(private val binding: ItemSecondBinding): RecyclerView.ViewHolder(binding.root){
            var menu : TextView = binding.textName
            var image : ImageView = binding.image
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
            val binding = ItemSecondBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return  SecondViewHolder(binding)
        }

        override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
            val currentItem =secondList[position]
            holder.menu.text = secondList[position].menu

            Glide.with(holder.itemView)
                .load(currentItem.image)
                .into(holder.image)

        }
        override fun getItemCount(): Int {
            return secondList.size
        }
    }