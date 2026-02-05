package com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts
import com.alilopez.demo.features.jsonplaceholder.domain.usescases.GetPostsUseCase
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.PostsUIState
import com.alilopez.demo.features.rickandmorty.domain.usecases.GetCharactersUseCase
import com.alilopez.demo.features.rickandmorty.presentation.screens.CharactersUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostsViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(PostsUIState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    private fun loadPosts(){
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getPostsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, posts = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}