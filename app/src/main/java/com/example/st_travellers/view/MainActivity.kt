package com.example.st_travellers.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.st_travellers.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnVerMas = findViewById<Button>(R.id.btnVerMas)
        btnVerMas.setOnClickListener {
            val intent = Intent(this, PoiListActivity::class.java)
            startActivity(intent)
        }
    }
}