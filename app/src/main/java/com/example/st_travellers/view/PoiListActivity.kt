package com.example.st_travellers.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_travellers.R
import com.example.st_travellers.data.model.PoiData
import com.example.st_travellers.viewModel.PoiListViewModel

class PoiListActivity : AppCompatActivity(), PoiListAdapter.OnItemClickListener {

    private lateinit var poiList: List<PoiData>
    private lateinit var poiListAdapter: PoiListAdapter
    private lateinit var poiRecyclerView: RecyclerView
    private val poiListViewModel: PoiListViewModel by viewModels()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.poi_list_activity)

        val loadingBar = findViewById<ProgressBar>(R.id.loadingBar)

        poiListViewModel.onCreate()

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        poiListViewModel.poilist.observe(this, {
            poiList = it
            poiListAdapter = PoiListAdapter(poiList,this)
            poiListAdapter.notifyDataSetChanged()
            poiRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = poiListAdapter
                setHasFixedSize(false)
            }
        })

        poiList = emptyList()

        poiListViewModel.isLoading.observe(this, {
            loadingBar.isVisible = it
        })
    }

    override fun onItemClick(position: Int) {
        val clickedItem: PoiData = poiList[position]
        val intent = Intent(this, PoiActivity::class.java)
        intent.putExtra("poiName", clickedItem.nombre)
        intent.putExtra("poiRanking", clickedItem.puntuacion.toString())
        intent.putExtra("poiDescription", clickedItem.descripcioncompleta)
        intent.putExtra("poiImage", clickedItem.imagen)
        startActivity(intent)
    }

}



