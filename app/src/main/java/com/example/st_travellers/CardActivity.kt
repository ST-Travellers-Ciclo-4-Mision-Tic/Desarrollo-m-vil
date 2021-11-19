package com.example.st_travellers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CardActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_card)

        val cardView = findViewById<Button>(R.id.card)
        cardView.setOnClickListener{
            val intent = Intent(this, PoiActivity::class.java)
            startActivity(intent)
        }
    }
}