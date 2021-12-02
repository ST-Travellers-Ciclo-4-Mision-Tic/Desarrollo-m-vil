package com.example.st_travellers.data.network

import com.example.st_travellers.data.model.Poi
import retrofit2.http.GET

interface PoisApiClient {
    @GET("db/")
    suspend fun getAllPois(): Poi
}