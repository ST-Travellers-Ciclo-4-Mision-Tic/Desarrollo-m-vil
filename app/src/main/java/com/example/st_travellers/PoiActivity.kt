package com.example.st_travellers

import android.os.Build
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class PoiActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_activity)
        //Obtener info del listado
        //poiName viene de poiListActivity
        //con getExtraString lo lees y lo asignas a una variable
        val poiName = intent.getStringExtra("poiName").toString()

        println(poiName)
    }
}