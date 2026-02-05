package com.alilopez.demo.features.jsonplaceholder.data.repositories

import android.util.Log
import com.alilopez.demo.core.network.JsonPlaceHolderApi
import com.alilopez.demo.core.network.RickAndMortyApi
import com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.mapper.toDomain
import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.PostsRepository
import com.alilopez.demo.features.rickandmorty.data.datasources.remote.mapper.toDomain


class PostsRepositoryImpl(
        private val api: JsonPlaceHolderApi
) : PostsRepository {

    override suspend fun getPosts(): List<Posts> {
        val response = api.getPosts()
        Log.d("JsonPlaceHolder",response.toString())
        return response.map { it.toDomain() }
    }
}