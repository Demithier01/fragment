package com.example.fragment.third_item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.Model.Toast
import com.example.fragment.R


class ToastFragment : Fragment() {
    private lateinit var toastAdapter: ToastAdapter
    private lateinit var toastRecyclerView: RecyclerView
    private lateinit var toastList: ArrayList<Toast>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.third_toast, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

    }
    private fun init(view: View) {
        toastList = ArrayList()
        toastRecyclerView= view.findViewById(R.id.reView)
        toastRecyclerView.setHasFixedSize(true)
        toastRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        addList()
        toastAdapter = ToastAdapter(toastList)
        toastRecyclerView.adapter = toastAdapter
    }
    private fun addList() {
        toastList.add(Toast("Honey Toast", "https://janjirainchuan.files.wordpress.com/2015/02/1416480302.jpeg"))
        toastList.add(Toast("French Toast", "https://sugarspunrun.com/wp-content/uploads/2023/08/French-Toast-recipe-1-of-1.jpg"))
        toastList.add(Toast("Toast Cream Egg Salted", "https://www.gourmetandcuisine.com/Images/editor_upload/_editor20191007034859_original.jpg"))
        toastList.add(Toast("Purple Sweet Potato Custard", "https://img.wongnai.com/p/1920x0/2017/08/22/9cc38ea0bbbb4c6795194a08e63030b2.jpg"))
        toastList.add(Toast("FrenchToastSticks", "https://www.pholfoodmafia.com/wp-content/uploads/2018/07/1500x924CinnamonFrenchToastSticks.jpg"))
        toastList.add(Toast("Pizza Toast", "https://www.pholfoodmafia.com/wp-content/uploads/2020/10/4Ham-Cheese-Pizza-Toast.jpg"))
        toastList.add(Toast("Marshmallow Toast", "https://i.ytimg.com/vi/PagW5Zi51ho/maxresdefault.jpg"))
        toastList.add(Toast("Brown Sugar Toast " , "https://www.proudsugarofficial.com/application/files/cache/thumbnails/571df42bd6821e340e391a35402b7692.jpg"))

    }
}