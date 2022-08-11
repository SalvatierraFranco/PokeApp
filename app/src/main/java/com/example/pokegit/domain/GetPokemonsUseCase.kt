package com.example.pokegit.domain

import com.example.pokegit.data.PokeRepository
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.PokeResponse
import com.example.pokegit.data.model.Pokemon

class GetPokemonsUseCase {

    suspend operator fun invoke(): List<Pokemon>? = PokeRepository().getPokemons()

    suspend fun getPokeMore(offset: Int, limit: Int): List<Pokemon>? =
        PokeRepository().getPokeMore(offset, limit)

    suspend fun getPokeInfo(id: Int): PokeInfo? = PokeRepository().getPokeInfo(id)
}