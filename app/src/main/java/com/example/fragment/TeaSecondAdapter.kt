package com.example.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.fragment.databinding.TeaSecondBinding

class TeaSecondAdapter(private val imageUrl: MutableList<String>, private val viewPager2: ViewPager2)
    : RecyclerView.Adapter<TeaSecondAdapter.TeaSecondViewHolder>() {

    class TeaSecondViewHolder(private val binding: TeaSecondBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imgV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeaSecondViewHolder {
        val binding = TeaSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeaSecondViewHolder(binding)
    }

    override fun getItemCount(): Int = imageUrl.size

    override fun onBindViewHolder(holder: TeaSecondViewHolder, position: Int) {
        Glide.with(holder.imageView.context)
            .load(imageUrl[position])
            .into(holder.imageView)

        if (position == imageUrl.size - 1) {
            viewPager2.post(runnable)
        }
    }

    private val runnable = Runnable {
        val originalSize = imageUrl.size
        imageUrl.addAll(imageUrl.subList(0, 7))
        notifyItemRangeInserted(originalSize, 7)
    }
}
