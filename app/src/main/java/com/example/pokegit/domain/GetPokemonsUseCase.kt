package com.example.pokegit.domain

import com.example.pokegit.data.PokeRepository
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.PokeResponse
import com.example.pokegit.data.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    var pokeRepo: PokeRepository
) {

    suspend operator fun invoke(): List<Pokemon>? = pokeRepo.getPokemons()

    suspend fun getPokeMore(offset: Int, limit: Int): List<Pokemon>? =
        pokeRepo.getPokeMore(offset, limit)

    suspend fun getPokeInfo(id: Int): PokeInfo? = pokeRepo.getPokeInfo(id)
}