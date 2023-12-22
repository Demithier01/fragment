package com.example.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.third_item.BingsuFragment
import com.example.fragment.third_item.IceCreamFragment
import com.example.fragment.third_item.ToastFragment

class ItemThirdAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> BingsuFragment()
            1 -> IceCreamFragment()
            2 -> ToastFragment()
            else -> BingsuFragment()
        }
    }
}