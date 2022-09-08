package com.example.pokegit.data.model

data class PokeInfo(
    var height: String,
    var name: String,
    var stats: List<Stats>,
    var types: List<Types>,
    var weight: String
)

data class Stats(var base_stat: String)

data class Types(var slot: String, var type: FinalType)

data class FinalType(var name: String, var url: String)