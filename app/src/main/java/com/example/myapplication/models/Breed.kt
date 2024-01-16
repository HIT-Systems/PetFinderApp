package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Breed(
    val primary: String?,
    val secondary: String?,
    val mixed: Boolean?,
    val unknown: Boolean?,
    val colors: Colors?,
) : Parcelable