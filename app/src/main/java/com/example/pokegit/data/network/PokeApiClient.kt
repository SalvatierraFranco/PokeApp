package com.example.pokegit.data.network

import com.example.pokegit.data.model.PokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokeApiClient {
    @GET("pokemon")
    suspend fun getAllPokemons(): Response<PokeResponse>
}