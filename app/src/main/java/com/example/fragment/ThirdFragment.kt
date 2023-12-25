package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ThirdFragment : Fragment() {

    private val tabTitles = arrayOf("BingSu", "Ice Cream", "Toast")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the correct layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager2)
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)

        viewPager.adapter = ItemThirdAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
