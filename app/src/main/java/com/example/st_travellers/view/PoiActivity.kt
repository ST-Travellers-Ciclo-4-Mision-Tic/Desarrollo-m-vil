package com.example.st_travellers.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.st_travellers.R
import com.squareup.picasso.Picasso

class PoiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_activity)
        //Obtener info del listado
        //poiName viene de poiListActivity
        //con getExtraString lo lees y lo asignas a una variable
        //variables de las vistas
        val tituloPoi: TextView = findViewById(R.id.poiTitle)
        tituloPoi.text = intent.getStringExtra("poiName").toString()
        val ranking: TextView = findViewById(R.id.rankingTextPoi)
        val rankingTop = intent.getStringExtra("poiRanking").toString()
        ranking.text = "$rankingTop/5"
        val poiImage: ImageView = findViewById(R.id.poiImage)
        Picasso.get().load(intent.getStringExtra("poiImage")).resize(1000, 600).into(poiImage)
        val descriptionPoi: TextView = findViewById(R.id.descriptionPoi)
        descriptionPoi.text = intent.getStringExtra("poiDescription")

    }
}