package com.example.ratingoffilms.model.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ratingoffilms.controller.fragmentcontroller.AwardsFragment
import com.example.ratingoffilms.controller.fragmentcontroller.FilmsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){

    //два экрана для перелистывания
    override fun getItemCount(): Int {
        return 2
    }

    //экраны для перелистывания
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FilmsFragment()
            else -> AwardsFragment()
        }
    }

}