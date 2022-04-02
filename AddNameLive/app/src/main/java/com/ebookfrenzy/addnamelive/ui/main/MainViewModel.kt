package com.ebookfrenzy.addnamelive.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    public var name: MutableLiveData<String> = MutableLiveData()
    var nameList: ArrayList<MutableLiveData<String>> = ArrayList()
    public var result: MutableLiveData<String> = MutableLiveData()

    fun displayName() {
        var nameList: ArrayList<MutableLiveData<String>> = ArrayList()
        if(!name.value.equals("")) {
            nameList.add(name)
            for (name in nameList) {
                result.value = result.value + name.value + "\n"
            }
        }else{
            result.value = "No names to display" + "\n"
        }
    }
}

