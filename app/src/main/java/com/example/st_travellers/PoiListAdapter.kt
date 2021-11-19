package com.example.st_travellers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PoiListAdapter(
    private val poiList: List<Poi>
): RecyclerView.Adapter<PoiListAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi_card, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = poiList[position]
        holder.bind(poi)
    }

    override fun getItemCount(): Int = poiList.size

    class PoiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val nombreTextView: TextView = itemView.findViewById(R.id.nombrePOI)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionPOI)
        private val ranking: TextView = itemView.findViewById(R.id.rankingPOI)
        private val image: ImageView = itemView.findViewById(R.id.imagePoiList)

        fun bind(poi: Poi) {
            Log.d("Nombre: ", poi.nombre)
            nombreTextView.text = poi.nombre
            descripcionTextView.text = poi.descripcion
            ranking.text = poi.puntuacion.toString()
            Picasso.get().load("https://cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/GLJZRZ34WVDBDD4UC2V53Z4YHM.jpg").into(image)
        }
    }
}