package com.example.pokegit.domain

import com.example.pokegit.data.PokeRepository
import com.example.pokegit.data.model.Pokemon

class GetPokemonsUseCase {

    suspend operator fun invoke(): List<Pokemon>? = PokeRepository().getPokemons()

}