package com.example.st_travellers.data

import com.example.st_travellers.data.model.PoiData
import com.example.st_travellers.data.network.PoiService

class Repository {
    private val api = PoiService()

    suspend fun getAllPois(): List<PoiData> {
        val response = api.getPois()
        return response
    }
}