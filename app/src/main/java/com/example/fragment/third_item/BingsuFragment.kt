package com.example.fragment.third_item

import BingsuAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment.R

class BingsuFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var adapter: BingsuAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_third_bingsu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        setUPTransformer()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
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

    private fun setUPTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View) {
        viewPager2 = view.findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)

        val imageUrls = mutableListOf(
            "https://f.ptcdn.info/467/059/000/pe8fyp1u2KWzzTuJad5-o.jpg",
            "https://www.ryoiireview.com/upload/article/201703/1490937411_1bfe8767df7c3b51ed4a759f42b3dd39.jpg",
            "https://cdn.pixabay.com/photo/2018/12/11/09/34/bingsu-3868700_1280.jpg",
            "https://www.ryoiireview.com/upload/article/201802/1517902751_467d516f5e5ba2f0f1a73535a33b2db2.jpg",
            "https://img.wongnai.com/p/1920x0/2017/05/16/aa2b9594ced4452bb1e2949e9ab2ed38.jpg",
            "https://www.ryoiireview.com/upload/article/201611/1479353464_d501901ff6df45f06a82566690bb0597.jpg",
            "https://pbs.twimg.com/media/C4t22TaVMAA51vX.jpg"
        )

        adapter = BingsuAdapter(imageUrls, viewPager2)


        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

}
