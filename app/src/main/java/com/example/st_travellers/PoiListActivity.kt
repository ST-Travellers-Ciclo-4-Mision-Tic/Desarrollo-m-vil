package com.example.st_travellers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PoiListActivity: AppCompatActivity() {

    private lateinit var poiList: ArrayList<POI>
    private lateinit var poiListAdapter: PoiListAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_list_activity)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        poiList = createPOIMock()
        poiListAdapter = PoiListAdapter(poiList)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiListAdapter
            setHasFixedSize(false)
        }
    }
        private fun createPOIMock(): ArrayList<POI> {

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

        }
}