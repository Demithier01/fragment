package com.example.fragment.third_item

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide.init
import com.example.fragment.ItemSecondAdapter
import com.example.fragment.Model.Second
import com.example.fragment.R

class IceCreamFragment : Fragment() {
    private lateinit var iceCreamRecyclerView: RecyclerView
    private lateinit var adapter: IceCreamAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_third_ice_cream, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        iceCreamRecyclerView = view.findViewById(R.id.rcView)
        iceCreamRecyclerView.setHasFixedSize(true)
        iceCreamRecyclerView.layoutManager =
            LinearLayoutManager(requireContext()) // Use requireContext() instead of this.context

        val textList = mutableListOf(
            "Vanilla ",
            "Lemon Cheese Ice Cream Pie",
            "Strawberry",
            "Mint Chocolate Chip",
            "Butter Pecan ",
            "Cookies n' Cream",
            "Pistachio",
            "Butterscotch",
            "Chocolate Peanut Butter"
        )
        adapter = IceCreamAdapter(textList)
        iceCreamRecyclerView.adapter = adapter
    }
}