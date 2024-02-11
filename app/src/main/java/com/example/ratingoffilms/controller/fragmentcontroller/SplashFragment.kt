package com.example.ratingoffilms.controller.fragmentcontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.ratingoffilms.R
import com.example.ratingoffilms.viewmodel.SplashViewModel

class SplashFragment : Fragment() {

    private var splashViewModel: SplashViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
        splashViewModel?.startProgress()

        splashViewModel?.flagFinish?.observe(viewLifecycleOwner){
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_rootFragment)
        }

    }
}