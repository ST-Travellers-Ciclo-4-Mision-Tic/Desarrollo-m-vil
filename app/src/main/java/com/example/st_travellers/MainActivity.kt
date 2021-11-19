package com.example.st_travellers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnVerMas = findViewById<Button>(R.id.btnVerMas)
        btnVerMas.setOnClickListener {
            //IO: Network y database || Main: cosas en el main thread || default: cosas pesadas
            CoroutineScope(IO).launch {
                println(getJsonFromWeb())
            }
            val intent = Intent(this, PoiListActivity::class.java)
            startActivity(intent)
        }
        //Para acceder a los valores de los strings en strings.xml
        // val titulo: String = getString(R.string.arrows)
    }
}