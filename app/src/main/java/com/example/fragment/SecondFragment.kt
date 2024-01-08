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

        //สร้าง Callback ให้กับ ViewPager2 ทำให้หน้าใน ViewPager2 ทำการสลับโดยอัตโนมัติ
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
        handler.removeCallbacks(runnable) //จะหยุดการทำงานของ runnable
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000) //เปลี่ยนหน้าใน ViewPager2 ทุก ๆ 2 วินาที
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransform() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f //กำหนดขนาดรูปภาพที่ใช้แสดง
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View) {
        viewPager2 = view.findViewById(R.id.vp2)
        handler = Handler(Looper.myLooper()!!)
        secondList = ArrayList()
        secondRecyclerView = view.findViewById(R.id.recyclerView1)
        secondRecyclerView.setHasFixedSize(true)
        secondRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val imageUrl = mutableListOf(
            "https://www.aromathailand.com/wp-content/uploads/2023/09/Americano_pic3.jpeg",
            "https://www.aromathailand.com/wp-content/uploads/2023/04/Cover-Mocha-1080x675.jpg",
            "https://www.nescafe.com/th/sites/default/files/2023-08/RecipeHero_IcedCaramelLatte_1066x1066.jpg",
            "https://d1mf4ril8efyfr.cloudfront.net/media/store_557/products/d3aeb4f5-5af6-4bf3-9936-582b2b2a9394.jpg",
            "https://madeinrecipes.com/wp-content/uploads/2021/06/%E0%B8%8A%E0%B8%B2%E0%B9%84%E0%B8%97%E0%B8%A2%E0%B8%84%E0%B8%B5%E0%B9%82%E0%B8%95-%E0%B8%8A%E0%B8%87%E0%B8%87%E0%B9%88%E0%B8%B2%E0%B8%A2-%E0%B8%AB%E0%B8%AD%E0%B8%A1%E0%B9%83%E0%B8%9A%E0%B8%8A%E0%B8%B2-Keto-Thai-Tea.jpg",
            "https://static.vecteezy.com/system/resources/previews/016/586/251/large_2x/product-cold-drink-menu-of-mixed-cocoa-chocolate-mint-drink-in-a-plastic-glass-free-photo.jpg",
            "https://img.freepik.com/premium-photo/iced-peach-drink-perfect-drink-catalog_718046-1398.jpg"
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
        secondList.add(Second("Espresso", "https://www.nestleprofessional.co.th/sites/default/files/styles/np_recipe_detail/public/2022-04/nescafe-iced-espresso-540x400.jpg?itok=cGl4pcYu"))
        secondList.add(Second("Yuzu orange coffee fresh","https://chefoldschool.com/wp-content/uploads/2023/05/3-1.jpg"))
        secondList.add((Second("Mocha","https://www.aromathailand.com/wp-content/uploads/2023/04/Cover-Mocha-1080x675.jpg")))
        secondList.add(Second("Latte", "https://img.salehere.co.th/p/600x0/2021/06/29/9qouf4swhzge.jpg"))
        secondList.add(Second("Caramel Macchiato", "https://www.nescafe.com/th/sites/default/files/2023-08/RecipeHero_IcedCaramelLatte_1066x1066.jpg"))
        secondList.add(Second("Coco", "https://api2.krua.co/wp-content/uploads/2020/07/RD0198_Gallery_-02-scaled.jpg"))
        secondList.add(Second("Bubble Tea", "https://files.gqthailand.com/uploads/mm8.jpg"))
        secondList.add(Second("Matcha Latte", "https://d1mf4ril8efyfr.cloudfront.net/media/store_557/products/d3aeb4f5-5af6-4bf3-9936-582b2b2a9394.jpg"))
        secondList.add(Second("GreenTea", "https://img.wongnai.com/p/1920x0/2019/02/02/1e0e327a52ce405196bb7242d22ea752.jpg"))
        secondList.add(Second("ThaiTea", "https://madeinrecipes.com/wp-content/uploads/2021/06/%E0%B8%8A%E0%B8%B2%E0%B9%84%E0%B8%97%E0%B8%A2%E0%B8%84%E0%B8%B5%E0%B9%82%E0%B8%95-%E0%B8%8A%E0%B8%87%E0%B8%87%E0%B9%88%E0%B8%B2%E0%B8%A2-%E0%B8%AB%E0%B8%AD%E0%B8%A1%E0%B9%83%E0%B8%9A%E0%B8%8A%E0%B8%B2-Keto-Thai-Tea.jpg"))
        secondList.add(Second("Cocoa Mint","https://static.vecteezy.com/system/resources/previews/016/586/251/large_2x/product-cold-drink-menu-of-mixed-cocoa-chocolate-mint-drink-in-a-plastic-glass-free-photo.jpg"))
        secondList.add(Second("Peach Tea","https://img.freepik.com/premium-photo/iced-peach-drink-perfect-drink-catalog_718046-1398.jpg"))
        secondList.add(Second("Nestea Black Tea","https://www.nestleprofessional.co.th/sites/default/files/styles/np_recipe_detail/public/2022-04/nestea-black-tea-540x400.jpg?itok=abNXW_oE"))
        secondList.add(Second("Lemon Tea", "https://img.th.my-best.com/content_section/beforehand_tips/885dc78edcd76c89663393d15bbee0f2.jpeg?ixlib=rails-4.3.1&q=70&lossless=0&w=690&fit=max&s=76aaeec9170346ea37132c48ceea88a9"))
    }
}
