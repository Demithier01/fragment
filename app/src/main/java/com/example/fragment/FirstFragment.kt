package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class FirstFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Int>
    private lateinit var itemFirstAdapter: ItemFirstAdapter

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        itemList = ArrayList()
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        addList()
        itemFirstAdapter = ItemFirstAdapter(itemList)
        recyclerView.adapter = itemFirstAdapter
    }
    private fun addList(){
        itemList.add(R.drawable.chocolate_lava)
        itemList.add(R.drawable.crepe_cake_strawberry)
        itemList.add(R.drawable.macaron)
        itemList.add(R.drawable.matcha_greentea_cheesecake)
        itemList.add(R.drawable.pancakes_raspberries)
        itemList.add(R.drawable.waffle_ice_cream)
        itemList.add(R.drawable.tiramisu)
    }

}