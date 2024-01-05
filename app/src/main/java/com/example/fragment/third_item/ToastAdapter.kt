package com.example.fragment.third_item

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragment.Model.First
import com.example.fragment.Model.Toast
import com.example.fragment.databinding.ItemFirstBinding
import com.example.fragment.databinding.ItemThirdToastBinding
import com.example.fragment.databinding.ThirdToastBinding

class ToastAdapter(private val toastList: List<Toast>):
RecyclerView.Adapter<ToastAdapter.ToastViewHolder>() {
    class ToastViewHolder(private val binding: ItemThirdToastBinding) : RecyclerView.ViewHolder(binding.root){
        val nToast : TextView = binding.textNameToast
        val imgToast : ImageView = binding.imageToast
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToastViewHolder {
       val binding = ItemThirdToastBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToastViewHolder, position: Int) {
        val currentItem =toastList[position]
        holder.nToast.text = toastList[position].nToast

        Glide.with(holder.itemView)
            .load(currentItem.imgToast)
            .into(holder.imgToast)
    }

    override fun getItemCount(): Int {
        return toastList.size
    }

}