package com.example.pokegit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokegit.data.model.Pokemon
import com.example.pokegit.domain.GetPokemonsUseCase
import kotlinx.coroutines.launch

class PokeViewModel: ViewModel() {

    var pokeLiveData = MutableLiveData<List<Pokemon>>()
    var getPokemonsUseCase = GetPokemonsUseCase()

    fun onCreate(){
        viewModelScope.launch {
            var response = getPokemonsUseCase()

            if(!response.isNullOrEmpty()){
                pokeLiveData.postValue(response!!)
            }
        }
    }

    fun onCreateMore(offset: Int, limit: Int){
        viewModelScope.launch {
            var response = getPokemonsUseCase.getPokeMore(offset, limit)

            if(!response.isNullOrEmpty()){
                pokeLiveData.postValue(response!!)
            }
        }
    }
}