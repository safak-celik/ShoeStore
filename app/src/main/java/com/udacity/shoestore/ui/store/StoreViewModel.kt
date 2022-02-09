package com.udacity.shoestore.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.ui.store.model.ShoeEntity

class StoreViewModel : ViewModel() {
    /**
     * MutableLiveData: innen, da dieser veränderbar ist
     * LiveData: Nach außen für Zugriff --> nicht veränderbar
     */

    private val _shoeList = MutableLiveData<List<ShoeEntity>>()
    val shoeListLiveData: LiveData<List<ShoeEntity>> get() = _shoeList
    private val shoeList = mutableListOf<ShoeEntity>()

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter


    init {
        _shoeList.value = shoeList
        _counter.value = 1
    }

    fun addShoe(shoe: ShoeEntity) {
        shoeList.add(shoe)
        _counter.value = (counter.value)?.plus(1)
    }
}