package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    private lateinit var btnFirst: Button
    private lateinit var btnSecond: Button
    private lateinit var btnThird: Button
    private lateinit var fragmentCont: FrameLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        btnFirst = findViewById(R.id.btn_first)
//        btnSecond = findViewById(R.id.btn_second)
//        btnThird = findViewById(R.id.btn_third)
//        fragmentCont = findViewById(R.id.fragmentCont)
//
//        btnFirst.setOnClickListener {
//            reSultFragment(FirstFragment())
//        }
//        btnSecond.setOnClickListener {
//            reSultFragment(SecondFragment())
//        }
//        btnThird.setOnClickListener {
//            reSultFragment(ThirdFragment())
//        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentCont) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

//    private fun reSultFragment(fragment: Fragment) {
//        fragmentManager = supportFragmentManager
//        fragmentManager.beginTransaction().replace(R.id.fragmentCont, fragment).commit()
//    }
}
