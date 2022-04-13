package com.ebookfrenzy.intentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.intentproject.databinding.ActivityZoomBinding

class ZoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom)

        binding = ActivityZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val extras = intent.extras ?: return
        val position = extras.getInt("position")

        var d = IntentData()

        binding.titleText.text = d.titles[MainViewModel.arr[position][0]]
        binding.detailText.text = d.details[MainViewModel.arr[position][1]]
        binding.image.setImageResource(d.images[MainViewModel.arr[position][2]])
    }
}