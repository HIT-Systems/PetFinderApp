package com.example.myapplication.networking

import com.example.myapplication.BASE_URL
import com.example.myapplication.models.AnimalResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimalsAPI::class.java)
    }

    val retrofitToken by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OAuth::class.java)
    }
}