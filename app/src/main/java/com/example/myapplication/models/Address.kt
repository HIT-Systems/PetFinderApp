package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    val address1: String,
    val address2: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
) : Parcelable