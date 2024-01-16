package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attributes (
    val spayedNeutered : Boolean,
    val houseTrained:Boolean,
    val declawed: Boolean?,
    val specialNeeds: Boolean,
    val shotsCurrent: Boolean,
) : Parcelable