package com.alilopez.demo.features.jsonplaceholder.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alilopez.demo.core.navigation.FeatureNavGraph
import com.alilopez.demo.core.navigation.JsonPlaceHolder
import com.alilopez.demo.core.navigation.RickAndMorty
import com.alilopez.demo.features.jsonplaceholder.di.JsonPlaceHolderModule
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.PostsScreen
import com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels.PostsViewModel
import com.alilopez.demo.features.rickandmorty.di.CharactersModule
import com.alilopez.demo.features.rickandmorty.presentation.screens.CharactersScreen
import com.alilopez.demo.features.rickandmorty.presentation.viewmodels.CharactersViewModel

class JsonPlaceHolderNavGraph(
        private val jsonPlaceHolderModule: JsonPlaceHolderModule
    ) : FeatureNavGraph {

        override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
            navGraphBuilder.composable<JsonPlaceHolder> {

                val viewModel: PostsViewModel = viewModel(
                    factory = jsonPlaceHolderModule.providePostsViewModelFactory()
                )

                PostsScreen(
                    viewModel = viewModel,
                    onBackClick = { navController.navigateUp() }
                    //onCharacterClick = { id -> navController.navigate(CharacterDetail(id)) }
                )
            }
        }

}