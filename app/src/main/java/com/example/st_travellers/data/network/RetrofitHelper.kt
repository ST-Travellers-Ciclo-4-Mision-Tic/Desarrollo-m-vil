package com.example.st_travellers.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/AlfonsHoz/jsonprueba/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
