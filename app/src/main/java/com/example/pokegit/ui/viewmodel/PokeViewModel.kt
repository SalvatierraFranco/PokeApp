package com.example.pokegit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.Pokemon
import com.example.pokegit.domain.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(
    var getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    var pokeLiveData = MutableLiveData<List<Pokemon>>()
    var pokeInfoLiveData = MutableLiveData<PokeInfo>()
    //var getPokemonsUseCase = GetPokemonsUseCase()

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

    fun onCreatePokeInfo(id: Int){
        viewModelScope.launch {
            var response = getPokemonsUseCase.getPokeInfo(id)

            if(response != null){
                pokeInfoLiveData.postValue(response!!)
            }
        }
    }
}