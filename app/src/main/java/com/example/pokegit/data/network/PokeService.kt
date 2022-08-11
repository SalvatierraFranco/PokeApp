package com.example.pokegit.data.network

import com.example.pokegit.core.RetrofitHelper
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.PokeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class PokeService {

    var retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemons(): PokeResponse? {
        return withContext(Dispatchers.IO){
            var response = retrofit.create(PokeApiClient::class.java).getAllPokemons()
            response.body()
        }
    }

    suspend fun getPokeMore(offset: Int, limit: Int): PokeResponse? {
        return withContext(Dispatchers.IO){
            var response = retrofit.create(PokeApiClient::class.java).getPokeMore(offset, limit)
            response.body()
        }
    }

    suspend fun getPokeInfo(id: Int): PokeInfo?{
        return withContext(Dispatchers.IO){
            var response = retrofit.create(PokeApiClient::class.java).getPokeInfo(id)
            response.body()
        }
    }
}