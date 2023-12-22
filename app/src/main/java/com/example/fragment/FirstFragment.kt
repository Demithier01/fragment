package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fragment.Model.First

class FirstFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<First>
    private lateinit var itemFirstAdapter: ItemFirstAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
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
        itemList.add(First("Bask Cheesecake \nชีสหน้าไหม้",R.drawable.bask_cheesecake))
        itemList.add(First("Chocolate Lava \nเค้กลาวาช็อกโกแลต",R.drawable.chocolate_lava))
        itemList.add(First("Chewy Brownies",R.drawable.chewy_brownies))
        itemList.add(First("Cinnamon Roll",R.drawable.cinnamon_roll))
        itemList.add(First("French Toast",R.drawable.french_toast))
        itemList.add(First("Fruit Cake",R.drawable.fruit_cake))
        itemList.add(First("Japanese CustardPudding",R.drawable.japanese_custard_pudding))
        itemList.add(First("Jerry Cheesecake",R.drawable.jerry_cheesecake))
        itemList.add(First("Macaron",R.drawable.macaron))
        itemList.add(First("MatchaGreentea Cheesecake",R.drawable.matcha_greentea_cheesecake))
        itemList.add(First("Orange Cake",R.drawable.orange_cake))
        itemList.add(First("Pancakes Raspberries",R.drawable.pancakes_raspberries))
        itemList.add(First("Strawberry CrepeCake ",R.drawable.crepe_cake_strawberry))
        itemList.add(First("ThaiTea CrepeCake",R.drawable.thai_tea_crepe_cake))
        itemList.add(First("Tiramisu",R.drawable.tiramisu))
    }

}