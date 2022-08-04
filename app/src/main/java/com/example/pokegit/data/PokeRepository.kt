package com.example.pokegit.data

import com.example.pokegit.data.model.PokeProvider
import com.example.pokegit.data.model.Pokemon
import com.example.pokegit.data.network.PokeService

class PokeRepository {
    suspend fun getPokemons(): List<Pokemon>?{
        var response = PokeService().getPokemons()

        if(response != null){
            PokeProvider.pokemonList = response.results
        }
        return response!!.results
    }
}