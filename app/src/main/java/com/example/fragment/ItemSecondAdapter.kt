package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemSecondAdapter(private var secondList: List<Second>):
    RecyclerView.Adapter<ItemSecondAdapter.SecondViewHolder>() {
        class SecondViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var menu : TextView = itemView.findViewById(R.id.textName)
            var image : ImageView = itemView.findViewById(R.id.image)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_second,parent,false)
            return  SecondViewHolder(view)
        }

        override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
            holder.image.setImageResource(secondList[position].image)
            holder.menu.text = secondList[position].menu

        }
        override fun getItemCount(): Int {
            return secondList.size
        }
    }