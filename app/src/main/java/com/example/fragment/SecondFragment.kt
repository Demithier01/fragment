package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.Model.Second

class SecondFragment : Fragment() {

    private lateinit var secondRecyclerView: RecyclerView
    private lateinit var secondList: ArrayList<Second>
    private lateinit var secondAdapter: ItemSecondAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        secondList = ArrayList()
        secondRecyclerView = view.findViewById(R.id.recyclerView1)
        secondRecyclerView.setHasFixedSize(true)
        secondRecyclerView.layoutManager = LinearLayoutManager(requireContext()) // Use requireContext() instead of this.context

        addDataList()
        secondAdapter = ItemSecondAdapter(secondList)
        secondRecyclerView.adapter = secondAdapter
    }

    private fun addDataList() {
        secondList.add(Second("Americano", R.drawable.americano))
        secondList.add(Second("Coco", R.drawable.coco))
        secondList.add(Second("Espresso", R.drawable.espresso))
        secondList.add(Second("GreenTea", R.drawable.greentea))
        secondList.add(Second("ThaiTea", R.drawable.thaitea))
    }
}
