package com.example.st_travellers.data.network

import com.example.st_travellers.data.model.Poi
import com.example.st_travellers.data.model.PoiData
import retrofit2.http.GET

interface PoisApiClient {
    @GET("fa3f0195b04309e0f152/")
    suspend fun getAllPois(): Poi
}