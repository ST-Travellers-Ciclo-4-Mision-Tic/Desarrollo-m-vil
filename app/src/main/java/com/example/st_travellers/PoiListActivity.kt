package com.example.st_travellers

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PoiListActivity : AppCompatActivity(), PoiListAdapter.OnItemClickListener {

    private lateinit var poiList: List<Poi>
    private lateinit var poiListAdapter: PoiListAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_list_activity)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        poiList = returnJsonInList()
        poiListAdapter = PoiListAdapter(poiList, this)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiListAdapter
            setHasFixedSize(false)
        }
    }
    override fun onItemClick(position: Int) {
        val clickedItem: Poi = poiList[position]
        val intent = Intent(this, PoiActivity::class.java)
        intent.putExtra("poiName", clickedItem.nombre)
        intent.putExtra("poiRanking", clickedItem.puntuacion.toString())
        intent.putExtra("poiDescription", clickedItem.descripcion)
        intent.putExtra("poiImage", clickedItem.imagen)
        startActivity(intent)
    }


    private fun returnJsonInList(): List<Poi> {
        //utiliza la función de Utils.kt enviandole el contexto y el nombre del archivo.
        val jsonFileString = getJsonDataFromAssets(applicationContext, "poiList.json")
        val gson = Gson()

        /*guarda el tipo de dato en el cual se va a convertir la inforacion del json a un listado de
        objetos de Poi
        */
        val listPois = object : TypeToken<List<Poi>>() {}.type

        //Transforma el json en el arreglo de Poi
        val pois: List<Poi> = gson.fromJson(jsonFileString, listPois)
        return pois
    }
}



