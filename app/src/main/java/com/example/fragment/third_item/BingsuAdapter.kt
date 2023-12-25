package com.example.fragment.third_item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment.R

class BingsuAdapter(private val imageList: MutableList<Int>, private val viewPager2: ViewPager2)
    : RecyclerView.Adapter<BingsuAdapter.BingsuViewHolder>() {

    class BingsuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingsuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_bingsu, parent, false)
        return BingsuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: BingsuViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
        if (position == imageList.size - 1) {
            viewPager2.post(runnable)
        }
    }

    private val runnable = Runnable {
        val originalSize = imageList.size
        imageList.addAll(imageList.subList(0, 8))
        notifyItemRangeInserted(originalSize, 8)
    }
}
