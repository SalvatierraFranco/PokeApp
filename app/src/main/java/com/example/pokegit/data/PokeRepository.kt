package com.example.pokegit.data

import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.PokeProvider
import com.example.pokegit.data.model.Pokemon
import com.example.pokegit.data.network.PokeService
import javax.inject.Inject

class PokeRepository @Inject constructor(
    var api: PokeService
) {
    suspend fun getPokemons(): List<Pokemon>?{
        var response = api.getPokemons()

        if(response != null){
            PokeProvider.pokemonList = response.results
        }
        return response!!.results
    }

    suspend fun getPokeMore(offset: Int, limit: Int): List<Pokemon>?{
        var response = api.getPokeMore(offset, limit)

        if(response != null){
            PokeProvider.pokemonList = response.results
        }

        return response!!.results
    }

    suspend fun getPokeInfo(id: Int): PokeInfo?{
        var response = api.getPokeInfo(id)

        if(response != null){
            return response
        }
        return null
    }
}