package com.example.st_travellers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.st_travellers.R
import com.example.st_travellers.data.model.PoiData
import com.squareup.picasso.Picasso

class PoiListAdapter(
    private val poiList: List<PoiData>?,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PoiListAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poi_card, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = poiList?.get(position)
        if (poi != null) {
            holder.bind(poi)
        }
    }

    override fun getItemCount(): Int = (poiList?.size)?: 0

    inner class PoiViewHolder(
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val nombreTextView: TextView = itemView.findViewById(R.id.nombrePOI)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionPOI)
        private val ranking: TextView = itemView.findViewById(R.id.rankingPOI)
        private val image: ImageView = itemView.findViewById(R.id.imagePoiList)


        init {
            itemView.setOnClickListener(this)
        }

        fun bind(poi: PoiData) {
            nombreTextView.text = poi.nombre
            descripcionTextView.text = poi.descripcion
            ranking.text = poi.puntuacion.toString()
            Picasso.get().load(poi.imagen).resize(500, 350).into(image)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}