package com.alilopez.demo.features.jsonplaceholder.domain.repositories

import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts
import com.alilopez.demo.features.rickandmorty.domain.entities.Character

interface PostsRepository {
        suspend fun getPosts(): List<Posts>
}