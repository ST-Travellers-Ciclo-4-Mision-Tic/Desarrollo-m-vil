package com.example.st_travellers

import com.example.st_travellers.data.Repository
import com.example.st_travellers.data.model.PoiData

class GetPois { //val get = GetPois()
    private val repository = Repository()

    suspend operator fun invoke(): List<PoiData> = repository.getAllPois()
}