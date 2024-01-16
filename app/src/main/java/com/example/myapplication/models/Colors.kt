package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Colors(
    val primary: String?,
    val secondary: String?,
    val tertiary: String?,
) : Parcelable