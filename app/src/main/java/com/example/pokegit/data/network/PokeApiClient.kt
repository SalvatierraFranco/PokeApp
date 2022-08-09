package com.example.pokegit.data.network

import com.example.pokegit.data.model.PokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiClient {
    @GET("pokemon")
    suspend fun getAllPokemons(): Response<PokeResponse>

    @GET("pokemon")
    suspend fun getPokeMore(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokeResponse>
}