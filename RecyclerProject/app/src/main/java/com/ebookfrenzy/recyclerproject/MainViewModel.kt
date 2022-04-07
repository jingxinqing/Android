package com.ebookfrenzy.recyclerproject

import kotlin.random.Random
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {

        val arr = Array(8) { IntArray(3) { Random.nextInt(8) } }
    }

}