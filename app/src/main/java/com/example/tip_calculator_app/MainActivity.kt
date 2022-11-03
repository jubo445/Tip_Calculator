package com.example.tip_calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tip_calculator_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val costOfServiceField = binding.costOfServiceEditText.text.toString()

        val cost = costOfServiceField.toIntOrNull()

        if(cost==0 || cost==null){

            displayTip(0.0)

            return
        }

        val tipPercent=when(binding.percentGroup.checkedRadioButtonId){
            R.id.Option1->0.2
            R.id.Option2->0.15
            else ->0.1
        }

        var tip : Double =cost * tipPercent
        if (binding.roundUpSwitch.isChecked){

            tip = kotlin.math.ceil(tip)
        }



        displayTip(tip)




    }
    private fun displayTip(tip: Double){
        binding.displayTipAmountTv.text="$tip"
    }
}