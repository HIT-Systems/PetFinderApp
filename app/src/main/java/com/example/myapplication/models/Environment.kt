package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Environment(
    val children: Boolean,
    val dogs: Boolean,
    val cats: Boolean,
) : Parcelable