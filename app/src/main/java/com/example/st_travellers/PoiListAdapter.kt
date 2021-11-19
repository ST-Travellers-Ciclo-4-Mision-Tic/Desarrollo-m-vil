package com.example.st_travellers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoiListAdapter(
    private val poiList: ArrayList<POI>
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

        private var nombreTextView: TextView = itemView.findViewById(R.id.nombrePOI)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcionPOI)
        private var ranking: TextView = itemView.findViewById(R.id.rankingPOI)

        fun bind(poi: POI) {
            Log.d("Nombre: ", poi.nombre)
            nombreTextView.text = poi.nombre
            descripcionTextView.text = poi.descripcion
            ranking.text = poi.ranking.toString()
        }
    }
}