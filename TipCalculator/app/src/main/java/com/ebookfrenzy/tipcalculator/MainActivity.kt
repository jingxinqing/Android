package com.ebookfrenzy.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { calculateTip() }

    }


    fun calculateTip() {
        val stringInTextField = binding.billTotal.text.toString()

        if (stringInTextField.isNotEmpty()) {
            binding.textView2.text = "The tips are as follows:"
            val cost = stringInTextField.toDouble()
            val tip10 = NumberFormat.getCurrencyInstance().format(cost * 1.1)
            val tip15 = NumberFormat.getCurrencyInstance().format(cost * 1.15)
            val tip20 = NumberFormat.getCurrencyInstance().format(cost * 1.2)


            binding.textView.text = "10% = $tip10\n15% = $tip15\n20% = $tip20"
        } else {
            binding.textView.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}