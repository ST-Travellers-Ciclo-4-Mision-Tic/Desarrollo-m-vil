package com.example.st_travellers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
            val intent = Intent(this, PoiActivity::class.java)
            startActivity(intent)
        }

        //Para acceder a los valores de los strings en strings.xml
        // val titulo: String = getString(R.string.arrows)

        //utiliza la función de Utils.kt enviandole el contexto y el nombre del archivo.
        val jsonFileString = getJsonDataFromAssets(applicationContext, "poiList.json")
        Log.i("data", jsonFileString)
        val gson = Gson()

        /*guarda el tipo de dato en el cual se va a convertir la inforacion del json a un listado de
        objetos de Poi
        */
        val listPois = object : TypeToken<List<Poi>>() {}.type

        //Transforma el json en el arreglo de Poi
        val pois: List<Poi> = gson.fromJson(jsonFileString, listPois)
        pois.forEachIndexed { idx, poi ->
            Log.i("data", "> Item $idx:\n$poi")
        }

    }
}