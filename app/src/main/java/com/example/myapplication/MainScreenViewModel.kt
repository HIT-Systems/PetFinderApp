package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Animal
import com.example.myapplication.networking.Network
import kotlinx.coroutines.launch
import java.lang.Exception

class MainScreenViewModel : ViewModel() {

    val isLoading = MutableLiveData(false)
    val animalsList: MutableLiveData<List<Animal>> = MutableLiveData(listOf())
    val error: MutableLiveData<String> = MutableLiveData()

    fun getAnimals(page: Int) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                animalsList.value =
                    animalsList.value?.plus(
                        Network.retrofit.getAnimals(
                            page,
                            "Bearer $token"
                        ).animals
                    )
            }catch (e:Exception){
                error.value = e.message
            }
            isLoading.value = false
        }
    }
}