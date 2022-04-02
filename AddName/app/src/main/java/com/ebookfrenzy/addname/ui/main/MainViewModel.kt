package com.ebookfrenzy.addname.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val nameList: MutableList<String> = ArrayList()
    private val result = StringBuilder()
    fun setNameList(value: String) {
        nameList.add(value)
    }

    fun displayNameList(): StringBuilder {
        val result = StringBuilder()
        for(name in nameList)
            result.appendLine(name)
        return result
    }


}