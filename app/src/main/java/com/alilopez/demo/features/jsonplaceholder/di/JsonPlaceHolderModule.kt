package com.alilopez.demo.features.jsonplaceholder.di

import com.alilopez.demo.core.di.AppContainer
import com.alilopez.demo.features.jsonplaceholder.domain.usescases.GetPostsUseCase
import com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels.PostsViewModelFactory
import com.alilopez.demo.features.rickandmorty.domain.usecases.GetCharactersUseCase
import com.alilopez.demo.features.rickandmorty.presentation.viewmodels.CharactersViewModelFactory

class JsonPlaceHolderModule(
        private val appContainer: AppContainer
) {
        private fun provideGetPostsUseCase(): GetPostsUseCase {
            return GetPostsUseCase(appContainer.postsRepository)
        }

        fun providePostsViewModelFactory(): PostsViewModelFactory {
            return PostsViewModelFactory(
                getPostsUseCase = provideGetPostsUseCase()
            )
        }
}