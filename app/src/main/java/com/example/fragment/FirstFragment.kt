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
        itemList.add(First("Bask Cheesecake \nชีสหน้าไหม้","https://houseofnasheats.com/wp-content/uploads/2023/07/Basque-Cheesecake-1.jpg"))
        itemList.add(First("Chocolate Lava \nเค้กลาวาช็อกโกแลต","https://nomnompaleo.com/wp-content/uploads/2021/02/800-LavaCakes-aaDSC_9507.jpg"))
        itemList.add(First("Chewy Brownies","https://hostthetoast.com/wp-content/uploads/2020/02/The-Best-Fudgy-Homemade-Brownies-1.jpg"))
        itemList.add(First("Cinnamon Roll","https://www.thecookierookie.com/wp-content/uploads/2022/04/Bakery-Style-Cinnamon-Rolls-2-500x500.jpg"))
        itemList.add(First("French Toast","https://www.dessertfortwo.com/wp-content/uploads/2018/08/brioche-french-toast-9-735x1103.jpg"))
        itemList.add(First("Fruit Cake","https://therecipecritic.com/wp-content/uploads/2021/11/fruitcake.jpg"))
        itemList.add(First("Japanese CustardPudding","https://www.chopstickchronicles.com/wp-content/uploads/2016/05/Purin-2-4.jpg"))
        itemList.add(First("Jerry Cheesecake","https://shopee.co.th/blog/wp-content/uploads/2021/07/pic2-1.jpg"))
        itemList.add(First("Macaron","https://www.foxyfolksy.com/wp-content/uploads/2014/07/french-macarons-1200t.jpg"))
        itemList.add(First("MatchaGreentea Cheesecake","https://cdn.kuali.com/wp-content/uploads/2020/04/30181956/13.-Green-Tea-Bake-Cheesecake-281.jpg"))
        itemList.add(First("Strawberry CrepeCake ","https://healthytasteoflife.com/wp-content/uploads/2022/05/strawberry-crepe-cake-featured-image-1.jpg"))
        itemList.add(First("Creme Brulee \nแครมบรูว์เล","https://www.recipetineats.com/wp-content/uploads/2016/09/Creme-Brulee_8-SQ.jpg"))
    }

}