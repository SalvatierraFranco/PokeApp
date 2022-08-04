package com.example.pokegit.data.model

data class PokeResponse(
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<Pokemon>
)