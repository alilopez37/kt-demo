package com.alilopez.demo.core.network

import com.alilopez.demo.features.rickandmorty.data.datasources.remote.model.CharactersResponse
import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}