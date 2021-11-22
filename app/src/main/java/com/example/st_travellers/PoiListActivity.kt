package com.example.st_travellers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PoiListActivity : AppCompatActivity() {

    private lateinit var poiList: List<Poi>
    private lateinit var poiListAdapter: PoiListAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_list_activity)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        poiList = returnJsonInList()
        poiListAdapter = PoiListAdapter(poiList)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiListAdapter
            setHasFixedSize(false)
        }
    }

    //Función para pasar la información del JSON a una clase ya creada.
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