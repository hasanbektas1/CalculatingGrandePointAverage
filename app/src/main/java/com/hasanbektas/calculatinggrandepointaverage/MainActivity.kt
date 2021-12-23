package com.hasanbektas.calculatinggrandepointaverage

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.hasanbektas.calculatinggrandepointaverage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {

            if (binding.examText.text.isNotEmpty() && binding.examText2.text.isNotEmpty() && binding.examText3.text.isNotEmpty()){

                var exam1 = binding.examText.text.toString().toInt()
                var exam2 = binding.examText2.text.toString().toInt()
                var exam3 = binding.examText3.text.toString().toInt()

                var average: Float = (exam1+exam2+exam3) / 3.toFloat()

                if (average >=50){

                    binding.resultText.text="Result: "+average.toString()
                    binding.resultText.setTextColor(getColor(R.color.green))
                }
                else{
                    binding.resultText.text="Result: "+average.toString()
                    binding.resultText.setTextColor(getColor(R.color.red))
                }


            }else{

                binding.resultText.text="fill in all fields"
            }
        }

    }

    fun clean (view : View) {
        binding.examText.text.clear()
        binding.examText2.text.clear()
        binding.examText3.text.clear()
        binding.resultText.setText("")
    }
}