package com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.demo.features.jsonplaceholder.domain.usescases.GetPostsUseCase
import com.alilopez.demo.features.rickandmorty.domain.usecases.GetCharactersUseCase
import com.alilopez.demo.features.rickandmorty.presentation.viewmodels.CharactersViewModel

class PostsViewModelFactory (
        private val getPostsUseCase: GetPostsUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PostsViewModel(getPostsUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }