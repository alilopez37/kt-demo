package com.alilopez.demo.features.jsonplaceholder.domain.usescases

import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts
import com.alilopez.demo.features.jsonplaceholder.domain.repositories.PostsRepository
import com.alilopez.demo.features.rickandmorty.domain.entities.Character
import com.alilopez.demo.features.rickandmorty.domain.repositories.CharactersRepository

class GetPostsUseCase(
        private val repository: PostsRepository
    ) {

        suspend operator fun invoke(): Result<List<Posts>> {
            return try {
                val posts = repository.getPosts()

                val filteredPosts = posts.filter { it.title.isNotBlank() }

                if (filteredPosts.isEmpty()) {
                    Result.failure(Exception("No se encontraron post válidos"))
                } else {
                    Result.success(filteredPosts)
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }