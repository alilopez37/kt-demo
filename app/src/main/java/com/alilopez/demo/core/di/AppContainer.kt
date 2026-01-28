package com.alilopez.demo.core.di

import android.content.Context
import com.alilopez.demo.BuildConfig
import com.alilopez.demo.core.network.RickAndMortyApi
import com.alilopez.demo.features.rickandmorty.data.repositories.CharactersRepositoryImpl
import com.alilopez.demo.features.rickandmorty.domain.repositories.CharactersRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppContainer(context: Context) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val rickAndMortyApi: RickAndMortyApi by lazy {
        retrofit.create(RickAndMortyApi::class.java)
    }

    val charactersRepository: CharactersRepository by lazy {
        CharactersRepositoryImpl(rickAndMortyApi)
    }
}

