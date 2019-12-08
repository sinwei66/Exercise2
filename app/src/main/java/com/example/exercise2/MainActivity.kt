package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate:Button = findViewById(R.id.buttonCalculate)
        val btnReset:Button = findViewById(R.id.buttonReset)
        btnCalculate.setOnClickListener{calculateBMI()}
        btnReset.setOnClickListener{reset()}
    }

    private fun calculateBMI() {
        val weight: EditText = findViewById(R.id.editTextWeight)
        val height: EditText = findViewById(R.id.editTextHeight)
        val imageBMI: ImageView = findViewById(R.id.imageViewBMI)

        val toMeter = height.text.toString().toDouble() / 100
        val bmi = weight.text.toString().toDouble() / Math.pow(toMeter, 2.0)

        //(height.text.toString().toInt() * height.text.toString().toInt())
        textViewBMI.text = String.format("BMI: %.1f", bmi)

        if(bmi < 18.5)
        {
            imageBMI.setImageResource(R.drawable.under)
        }
        else if(bmi > 18.5 && bmi < 24.9)
        {
            imageBMI.setImageResource(R.drawable.normal)
        }
        else
        {
            imageBMI.setImageResource(R.drawable.over)
        }
    }

    private fun reset()
    {
        editTextWeight.setText("")
        //editTextHeight.setText(R.string.height)
        editTextHeight.getText().clear()
        textViewBMI.text = " "
        imageViewBMI.setImageResource((R.drawable.empty))
        //textViewBMI.setText(" ")
    }
}
