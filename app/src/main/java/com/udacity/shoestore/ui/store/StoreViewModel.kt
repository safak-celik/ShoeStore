package com.udacity.shoestore.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoreViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<ShoeEntity>>()
    val shoes: LiveData<MutableList<ShoeEntity>> = _shoes


    init {
        // First Data for testing
           _shoes.value = mutableListOf(ShoeEntity(null, null, null, null))
    }

    fun addShoe(name: String?, company: String?, size: String?, description: String?) {
        _shoes.value?.add(
            ShoeEntity(
                name = name,
                company = company,
                size = size,
                description = description
            )
        )
    }
}