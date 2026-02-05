package com.alilopez.demo.features.rickandmorty.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alilopez.demo.core.navigation.FeatureNavGraph
import com.alilopez.demo.core.navigation.RickAndMorty
import com.alilopez.demo.features.rickandmorty.di.CharactersModule
import com.alilopez.demo.features.rickandmorty.presentation.screens.CharactersScreen
import com.alilopez.demo.features.rickandmorty.presentation.viewmodels.CharactersViewModel

class CharactersNavGraph(
    private val charactersModule: CharactersModule
) : FeatureNavGraph {

    override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.composable<RickAndMorty> {

            val viewModel: CharactersViewModel = viewModel(
                factory = charactersModule.provideCharactersViewModelFactory()
            )

            CharactersScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
                //onCharacterClick = { id -> navController.navigate(CharacterDetail(id)) }
            )
        }
    }

}