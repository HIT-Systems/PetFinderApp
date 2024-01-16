package com.example.myapplication.models

data class AnimalResponse(
    val animals: List<Animal>,
    val pagination: Pagination,
)