package com.example.fragment.third_item

import BingsuAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment.Model.BingSu
import com.example.fragment.R

class BingsuFragment : Fragment() {
    private lateinit var reView: RecyclerView
    private lateinit var imageUrl: ArrayList<BingSu>
    private lateinit var adapter: BingsuAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_bingsu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        imageUrl = ArrayList()
        reView = view.findViewById(R.id.rvBingSu)
        reView.setHasFixedSize(true)
        reView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        addImageUrl()
        adapter = BingsuAdapter(imageUrl)
        reView.adapter = adapter

    }
    private fun addImageUrl(){
        imageUrl.add(BingSu("BingSu","https://f.ptcdn.info/467/059/000/pe8fyp1u2KWzzTuJad5-o.jpg"))
        imageUrl.add(BingSu("BingSu","https://cdn.pixabay.com/photo/2018/12/11/09/34/bingsu-3868700_1280.jpg"))
        imageUrl.add(BingSu("BingSu","https://pbs.twimg.com/media/C4t22TaVMAA51vX.jpg"))
        imageUrl.add(BingSu("BingSu","https://www.ryoiireview.com/upload/article/201703/1490937411_1bfe8767df7c3b51ed4a759f42b3dd39.jpg"))
        imageUrl.add(BingSu("BingSu","https://www.ryoiireview.com/upload/article/201802/1517902751_467d516f5e5ba2f0f1a73535a33b2db2.jpg"))
        imageUrl.add(BingSu("BingSu","https://img.wongnai.com/p/1920x0/2017/05/16/aa2b9594ced4452bb1e2949e9ab2ed38.jpg"))
        imageUrl.add(BingSu("BingSu","https://www.ryoiireview.com/upload/article/201611/1479353464_d501901ff6df45f06a82566690bb0597.jpg"))

    }

}
