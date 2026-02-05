package com.alilopez.demo.core.di

import android.content.Context
import com.alilopez.demo.BuildConfig
import com.alilopez.demo.core.network.JsonPlaceHolderApi
import com.alilopez.demo.core.network.RickAndMortyApi
import com.alilopez.demo.features.jsonplaceholder.data.repositories.PostsRepositoryImpl
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.PostsRepository
import com.alilopez.demo.features.rickandmorty.data.repositories.CharactersRepositoryImpl
import com.alilopez.demo.features.rickandmorty.domain.repositories.CharactersRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppContainer(context: Context) {

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val rickAndMortyRetrofit = createRetrofit(BuildConfig.BASE_URL_RICK)

    val rickAndMortyApi: RickAndMortyApi by lazy {
        rickAndMortyRetrofit.create(RickAndMortyApi::class.java)
    }

    val charactersRepository: CharactersRepository by lazy {
        CharactersRepositoryImpl(rickAndMortyApi)
    }

    // --- JSONPlaceholder API (Posts) ---
    private val postsRetrofit = createRetrofit(BuildConfig.BASE_URL_JSON)

    val jsonPlaceHolderApi: JsonPlaceHolderApi by lazy {
        postsRetrofit.create(JsonPlaceHolderApi::class.java)
    }

    val postsRepository: PostsRepository by lazy {
        PostsRepositoryImpl(jsonPlaceHolderApi)
    }
}

