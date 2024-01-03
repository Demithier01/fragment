package com.example.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment.Model.Second

class SecondFragment : Fragment() {

    private lateinit var secondRecyclerView: RecyclerView
    private lateinit var secondList: ArrayList<Second>
    private lateinit var secondAdapter: ItemSecondAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var teaSecondAdapter: TeaSecondAdapter
    private lateinit var handler: Handler
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
        setUpTransform()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }
        })
    }
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransform() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View) {
        viewPager2 = view.findViewById(R.id.vp2)
        handler = Handler(Looper.myLooper()!!)
        secondList = ArrayList()
        secondRecyclerView = view.findViewById(R.id.recyclerView1)
        secondRecyclerView.setHasFixedSize(true)
        secondRecyclerView.layoutManager = LinearLayoutManager(requireContext()) // Use requireContext() instead of this.context

        val imageUrl = mutableListOf(
            "https://f.ptcdn.info/467/059/000/pe8fyp1u2KWzzTuJad5-o.jpg",
            "https://www.ryoiireview.com/upload/article/201703/1490937411_1bfe8767df7c3b51ed4a759f42b3dd39.jpg",
            "https://cdn.pixabay.com/photo/2018/12/11/09/34/bingsu-3868700_1280.jpg",
            "https://www.ryoiireview.com/upload/article/201802/1517902751_467d516f5e5ba2f0f1a73535a33b2db2.jpg",
            "https://img.wongnai.com/p/1920x0/2017/05/16/aa2b9594ced4452bb1e2949e9ab2ed38.jpg",
            "https://www.ryoiireview.com/upload/article/201611/1479353464_d501901ff6df45f06a82566690bb0597.jpg",
            "https://pbs.twimg.com/media/C4t22TaVMAA51vX.jpg"
        )
        teaSecondAdapter = TeaSecondAdapter(imageUrl, viewPager2)

        viewPager2.adapter = teaSecondAdapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        addDataList()
        secondAdapter = ItemSecondAdapter(secondList)
        secondRecyclerView.adapter = secondAdapter
    }

    private fun addDataList() {
        secondList.add(Second("Americano", "https://www.aromathailand.com/wp-content/uploads/2023/09/Americano_pic3.jpeg"))
        secondList.add(Second("Coco", "https://api2.krua.co/wp-content/uploads/2020/07/RD0198_Gallery_-02-scaled.jpg"))
        secondList.add(Second("Espresso", "https://www.nestleprofessional.co.th/sites/default/files/styles/np_recipe_detail/public/2022-04/nescafe-iced-espresso-540x400.jpg?itok=cGl4pcYu"))
        secondList.add(Second("GreenTea", "https://img.wongnai.com/p/1920x0/2019/02/02/1e0e327a52ce405196bb7242d22ea752.jpg"))
        secondList.add(Second("ThaiTea", "https://madeinrecipes.com/wp-content/uploads/2021/06/%E0%B8%8A%E0%B8%B2%E0%B9%84%E0%B8%97%E0%B8%A2%E0%B8%84%E0%B8%B5%E0%B9%82%E0%B8%95-%E0%B8%8A%E0%B8%87%E0%B8%87%E0%B9%88%E0%B8%B2%E0%B8%A2-%E0%B8%AB%E0%B8%AD%E0%B8%A1%E0%B9%83%E0%B8%9A%E0%B8%8A%E0%B8%B2-Keto-Thai-Tea.jpg"))

    }
}
