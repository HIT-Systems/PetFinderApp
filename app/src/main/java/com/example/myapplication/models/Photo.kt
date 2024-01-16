package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val small: String?,
    val medium: String?,
    val large: String?,
    val full: String?,
) : Parcelable