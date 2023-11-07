package com.example.ratingoffilms.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel:ViewModel() {

    var flagFinish: MutableLiveData<Boolean> = MutableLiveData()

    fun startProgress(){
        viewModelScope.launch(Dispatchers.Main){
            delay(2000)
            flagFinish.value = true
        }
    }

}