package com.example.st_travellers.data.network

import com.example.st_travellers.data.model.PoiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class PoiService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPois(): List<PoiData> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PoisApiClient::class.java).getAllPois()
            response.pois
        }
    }

}