package com.udacity.shoestore.ui.store


import android.widget.ImageView


data class ShoeEntity(
    val name: String? = null,
    val company: String? = null,
    val size: String? = null,
    val description: String? = null,
    val image: ImageView? = null
)
