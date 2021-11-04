package com.example.st_travellers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: TextView = findViewById(R.id.btnAdd)
        val btnMinus: TextView = findViewById(R.id.btnMinus)
        val btnReset: TextView = findViewById(R.id.btnReset)
        val text: TextView = findViewById(R.id.resultado)
        var sum = 0

        btnAdd.setOnClickListener(View.OnClickListener {
            sum += 1
            text.text = sum.toString()
        })
        btnMinus.setOnClickListener(View.OnClickListener {
            sum -= 1
            text.text = sum.toString()
        })
        btnReset.setOnClickListener(View.OnClickListener {
            sum = 0
            text.text = sum.toString()
        })
    }
}