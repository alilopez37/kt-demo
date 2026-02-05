package com.alilopez.demo.features.jsonplaceholder.presentation.screens

import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts
import com.alilopez.demo.features.rickandmorty.domain.entities.Character

data class PostsUIState (
    val isLoading: Boolean = false,
    val posts: List<Posts> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
    )