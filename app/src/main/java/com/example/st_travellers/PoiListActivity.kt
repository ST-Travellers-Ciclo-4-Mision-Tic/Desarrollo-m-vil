package com.example.st_travellers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class PoiListActivity: AppCompatActivity() {

    private lateinit var poiList: ArrayList<POIItem>
    private lateinit var poiListAdapter: PoiListAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_list_activity)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        poiList = loadPOIMockFromJSON()
        poiListAdapter = PoiListAdapter(poiList)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiListAdapter
            setHasFixedSize(false)
        }
    }

        private fun loadPOIMockFromJSON(): ArrayList<POIItem> {
            var poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use {it.readText()}
            val gson = Gson()
            val data = gson.fromJson(poiString, POI::class.java)
            return data
        }

     /*   private fun createPOIMock(): ArrayList<POI> {

            return arrayListOf(
                POI(
                    nombre = "Puerta de Alcalá",
                    descripcion = "La descripción",
                    ranking = 4
                ),
                POI(
                    nombre = "Palacio de Cibeles",
                    descripcion = "La descripción 2",
                    ranking = 5
                ),
                POI(
                    nombre = "Jardín Botánico",
                    descripcion = "La descripción 3",
                    ranking = 5
                )
            )

        } */
}