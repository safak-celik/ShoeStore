package com.udacity.shoestore.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StoreViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company
    private val _size = MutableLiveData<Int>()
    val size: LiveData<Int>
        get() = _size
    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    init {
        _name.value = ""
        _company.value = ""
        _size.value = 0
        _description.value = ""
    }

}