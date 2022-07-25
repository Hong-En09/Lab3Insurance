package com.example.lab3insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3insurance.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO 2: Create an instance of view Binding
    //lateinit = late initialize
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 3: Initialize binding object
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

            var premium = when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4,5 -> 150
                else -> 0
            }

            if(gender == binding.radioButtonMale.id) {
                var extraPaymentForMale = when (age) {
                    0 -> 0
                    1 -> premium += 50
                    2 -> premium += 100
                    3 -> premium += 150
                    4, 5 -> premium += 200
                    else -> 0
                }
            }

            if(smoker) {
                var extraPaymentForSmoker = when (age) {
                    0 -> premium += 0
                    1 -> premium += 100
                    2 -> premium += 150
                    3 -> premium += 200
                    4 -> premium += 250
                    5 -> premium += 300
                    else -> 0
                }
            }

            //if(gender == binding.radioButtonMale.id){
            //    premium += 50
            //}

        val premium_output = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = premium_output

            //var premium2 = 0
            //if(age == 0){
            //    premium2 = 60
            //}else if(age == 1){
            //    premium2 = 70
            //}

        }
        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.textViewPremium.text = ""

        }
    }
}