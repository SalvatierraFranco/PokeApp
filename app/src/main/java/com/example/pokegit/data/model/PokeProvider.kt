package com.example.pokegit.data.model

import javax.inject.Inject

class PokeProvider {
    companion object{
        var pokemonList: List<Pokemon> = emptyList()
    }
}