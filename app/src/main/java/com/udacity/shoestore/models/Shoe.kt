package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * On Android, Parcelable is an interface that a class can implement to be passed within an Intent from an Activity to another one, this way,
 * transporting data from one Activity to another one.
 * Daten mit Intent zwischen Activities zu verschieben
 */

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable