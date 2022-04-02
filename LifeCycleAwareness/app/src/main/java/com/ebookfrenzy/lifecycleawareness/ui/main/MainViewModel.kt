package com.ebookfrenzy.lifecycleawareness.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import java.time.LocalDateTime

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    companion object{
        var output:MutableLiveData<String> = MutableLiveData()
        //output = ""
        //result
        //***** in observer with certain messages
        fun print(msg:String){
            output.value = output.value + "$msg " + LocalDateTime.now() + "\n" + "**********" + "\n"

        }

    }

}