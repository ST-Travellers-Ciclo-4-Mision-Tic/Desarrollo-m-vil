package com.example.st_travellers

import android.content.Context
import android.util.Log

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

//funcipon para traer la información de un json
fun getJsonDataFromAssets(context: Context, fileName: String): String {
    var jsonString: String = ""
    try {
        //abre y lee el archivo json y la guarda en la variable
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        println(e)
    }
    return jsonString
}

//Suspend dice que la función va a ser corrida en una corutina
suspend fun getJsonFromWeb(): Prueba? {
    //variable para guardar el response
    var response: Prueba? = null
    try {
        //cliente que va a hacer el request
        val client = HttpClient(CIO) { install(JsonFeature) }
        response =
            client.get("https://my-json-server.typicode.com/AlfonsHoz/jsonprueba/db/")
        println(response ?: "error")
        client.close()
    } catch (e: Exception) {
        Log.e("GET METHOD", e.toString())
    }
    return response
}
