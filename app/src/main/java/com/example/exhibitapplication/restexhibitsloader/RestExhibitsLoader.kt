package com.example.exhibitapplication.restexhibitsloader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exhibitapplication.model.Exhibit
import com.example.exhibitapplication.model.ExhibitApi
import kotlinx.coroutines.launch

class RestExhibitsLoader : ViewModel() {
    var exhibitList: List<Exhibit> by mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            getExhibits() }

    }

    private suspend fun getExhibits() {
        try {
            exhibitList = ExhibitApi.exhibitsLoader.getExhibitList()
        }
        catch (e: Exception){

        }


    }
}