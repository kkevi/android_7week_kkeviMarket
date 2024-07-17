package com.example.kkevi_market

import android.health.connect.datatypes.units.Temperature
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val location: String,
    val temperature: Double = 36.5,
) : Parcelable
