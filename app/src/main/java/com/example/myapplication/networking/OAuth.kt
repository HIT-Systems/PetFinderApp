package com.example.myapplication.networking

import com.example.myapplication.models.AnimalResponse
import com.example.myapplication.models.OAuthResponse
import com.example.myapplication.token
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface OAuth {
    @POST("v2/oauth2/token")
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun getToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("grant_type") grantType: String,
    ): OAuthResponse
}