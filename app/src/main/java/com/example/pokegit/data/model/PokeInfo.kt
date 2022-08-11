package com.example.pokegit.data.model

data class PokeInfo(
    var name: String,
    var types: List<Types>,
    var height: Int,
    var weight: Int,
    var stats: List<Stats>
)

data class Types(var slot: Int, var type: List<FinalType>)

data class FinalType(var name: String, var url: String)

data class Stats(var base_stat: Int)