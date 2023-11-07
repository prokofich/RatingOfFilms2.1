package com.example.ratingoffilms.controller.fragmentcontroller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.ratingoffilms.R
import com.example.ratingoffilms.model.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {

    private var ctx: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.id_tab_layout)
        val viewPager = view.findViewById<ViewPager2>(R.id.id_view_pager)
        tabLayout.tabIconTint = null
        viewPager.adapter = ViewPagerAdapter(ctx as FragmentActivity)
        TabLayoutMediator(tabLayout,viewPager){
                tab,pos ->
            when(pos){
                0 ->{
                    tab.text = "Films"
                }
                1 ->{
                    tab.text = "Awards"
                }
            }
        }.attach()
        return view
    }

}