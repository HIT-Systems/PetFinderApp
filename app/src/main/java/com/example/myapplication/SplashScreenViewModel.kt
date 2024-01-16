package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.networking.Network
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    val isLoading = MutableLiveData(true)

    fun getToken() {
        viewModelScope.launch {
            token = Network.retrofitToken.getToken(
                grantType = grant_type, clientId = clientId, clientSecret = clientSecret
            ).accessToken
            isLoading.value = false
        }
    }
}