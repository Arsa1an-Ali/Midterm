package com.example.midterm

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity

    class Calculator : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val num1 = intent.getDoubleExtra("NUM1", 0.0)
            val num2 = intent.getDoubleExtra("NUM2", 0.0)
            val operation = intent.getStringExtra("OPERATION")

            val result = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> 0.0
            }

            val resultIntent = Intent(this, ResultActivity::class.java)
            resultIntent.putExtra("RESULT", result)
            startActivity(resultIntent)
            finish()
        }
    }
