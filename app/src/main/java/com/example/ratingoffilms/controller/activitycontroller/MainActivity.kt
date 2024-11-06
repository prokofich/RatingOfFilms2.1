package com.example.ratingoffilms.controller.activitycontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ratingoffilms.R
import com.example.ratingoffilms.controller.fragmentcontroller.DetailFilmsFragment
import com.example.ratingoffilms.model.constant.MAIN

class MainActivity : AppCompatActivity() {

    private var idMovie = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MAIN = this

    }

    /** функция замены фрагмента на экране */
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host, fragment)
        transaction.commit()
    }

    /** показ фрагмента с описанием фильма */
    fun showDetailFragment() = replaceFragment(DetailFilmsFragment())

    /** установка id выбранного фильма */
    fun setIdMovie(id: Int) {
        idMovie = id
    }

    /** получение id выбранного фильма */
    fun getIdMovie(): Int = idMovie

}