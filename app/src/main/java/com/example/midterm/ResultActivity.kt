package com.example.midterm


    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity

    class ResultActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            val result = intent.getDoubleExtra("RESULT", 0.0)
            val textViewResult: TextView = findViewById(R.id.textView_result)
            textViewResult.text = result.toString()
        }
    }
