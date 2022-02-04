package com.udacity.shoestore.ui.store

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoreViewModel : ViewModel() {

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