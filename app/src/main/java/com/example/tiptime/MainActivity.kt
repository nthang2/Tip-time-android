package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            calculateTip()
        }
    }

    fun calculateTip() {
        val stringINTextField = binding.costOfService.text.toString()
        val cost = stringINTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.amazing -> 0.20
            R.id.good -> 0.18
            else -> 0.15
        }
        var tip = cost*tipPercentage

        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formatTip = NumberFormat.getCurrencyInstance().format(tip)
        val tipResult = binding.tipResult.setText(formatTip)
    }

}