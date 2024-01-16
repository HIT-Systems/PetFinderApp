package com.example.myapplication.networking

import com.example.myapplication.models.Animal
import com.example.myapplication.models.AnimalResponse
import com.example.myapplication.token
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimalsAPI {
    @GET("v2/animals")
    suspend fun getAnimals(
        @Query("page") page: Int,
        @Header("Authorization") auth: String,
    ): AnimalResponse
}