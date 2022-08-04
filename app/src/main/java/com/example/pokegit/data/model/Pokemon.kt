package com.example.pokegit.data.model

data class Pokemon(
    var name: String,
    var url: String
){
    fun getNum(): Int{
        var number = url.split("/")
        return (number.get(number.size - 2)).toInt()
    }
}