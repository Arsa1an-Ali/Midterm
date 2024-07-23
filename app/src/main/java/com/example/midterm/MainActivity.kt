package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNum1: EditText = findViewById(R.id.editText_num1)
        val editTextNum2: EditText = findViewById(R.id.editText_num2)
        val spinnerOperation: Spinner = findViewById(R.id.spinner_operation)
        val buttonCalculate: Button = findViewById(R.id.button_calculate)
        val buttonRecipe: Button = findViewById(R.id.button_recipe)

        // Set up the spinner with operations
        ArrayAdapter.createFromResource(
            this,
            R.array.operations_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerOperation.adapter = adapter
        }

        buttonCalculate.setOnClickListener {
            val num1Text = editTextNum1.text.toString()
            val num2Text = editTextNum2.text.toString()

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            } else {
                val num1 = num1Text.toDouble()
                val num2 = num2Text.toDouble()
                val operation = spinnerOperation.selectedItem.toString()

                val intent = Intent(this, Calculator::class.java)
                intent.putExtra("NUM1", num1)
                intent.putExtra("NUM2", num2)
                intent.putExtra("OPERATION", operation)
                startActivity(intent)
            }
        }

        buttonRecipe.setOnClickListener {
            // Assuming the Weather app has an activity named weather


            val intent = Intent(this, Weather::class.java)
            startActivity(intent)
        }
    }
}