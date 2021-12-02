package com.example.st_travellers.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.st_travellers.GetPois
import com.example.st_travellers.data.model.PoiData
import kotlinx.coroutines.launch

class PoiListViewModel : ViewModel() {
    val poilist = MutableLiveData<List<PoiData>>()
    val isLoading = MutableLiveData<Boolean>()
    var getPois = GetPois()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPois()
            if (!result.isNullOrEmpty()) {
                poilist.postValue(result)
            }
            isLoading.postValue(false)
        }
    }


}