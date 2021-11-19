package com.example.st_travellers


import com.google.gson.annotations.SerializedName

data class POIItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("ranking")
    val ranking: Int,
    @SerializedName("urlImage")
    val urlImage: String
)