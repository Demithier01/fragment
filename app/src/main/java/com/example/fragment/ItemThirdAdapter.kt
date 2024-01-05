package com.example.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.third_item.BingsuFragment
import com.example.fragment.third_item.IceCreamFragment
import com.example.fragment.third_item.ToastFragment
// ประกาศ ItemThirdAdapter ที่เป็น FragmentStateAdapter ที่ใช้ในการจัดการกับ Fragment ใน ViewPager2
class ItemThirdAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3 //จำนวนfragment ที่แสดงใน viewpager2
    }

    //เมื่อ ViewPager2 ทำการขอ Fragment ในตำแหน่งที่กำหนด (position) จะทำการสร้างและคืนค่า Fragment นั้น
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> BingsuFragment()
            1 -> IceCreamFragment()
            2 -> ToastFragment()
            else -> BingsuFragment()
        }
    }
}