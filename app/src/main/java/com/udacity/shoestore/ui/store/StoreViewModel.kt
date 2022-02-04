package com.udacity.shoestore.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoreViewModel : ViewModel() {
/*
    private val _shoeList = MutableLiveData<MutableList<ShoeEntity>>()
    val shoeList: LiveData<MutableList<ShoeEntity>> = _shoeList */

    private val _shoeList = MutableLiveData<List<ShoeEntity>>()
    val shoeListLiveData: LiveData<List<ShoeEntity>> get() = _shoeList
    private val shoeList = mutableListOf<ShoeEntity>()


    init {
        _shoeList.value = shoeList
    }

    fun addShoe(shoe: ShoeEntity) {
        shoeList.add(shoe)
    }
}