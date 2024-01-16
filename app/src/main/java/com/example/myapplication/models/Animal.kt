package com.example.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(
    val id: Int,
    val organizationId: String?,
    val url: String?,
    val type: String?,
    val species: String?,
    val breeds: Breed?,
    val age: String?,
    val gender: String?,
    val size: String?,
    val coat: String?,
    val attributes: Attributes?,
    val environment: Environment?,
    val tags: List<String>?,
    val name: String?,
    val description: String?,
    val photos: List<Photo>?,
    val videos: List<Video>?,
    val status: String?,
    val address: Address?,
) : Parcelable

