package com.alilopez.demo.features.home.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alilopez.demo.core.navigation.FeatureNavGraph
import com.alilopez.demo.core.navigation.Home
import com.alilopez.demo.core.navigation.JsonPlaceHolder
import com.alilopez.demo.core.navigation.RickAndMorty
import com.alilopez.demo.features.home.presentation.HomeScreen
import com.alilopez.demo.features.jsonplaceholder.di.JsonPlaceHolderModule
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.PostsScreen
import com.alilopez.demo.features.jsonplaceholder.presentation.viewmodels.PostsViewModel

class HomeNavGraph: FeatureNavGraph {
        override fun registerGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
            navGraphBuilder.composable<Home> {

                HomeScreen (
                    onClickRick = { navController.navigate(RickAndMorty) },
                    onClickJson = { navController.navigate(JsonPlaceHolder) }
                )
            }
        }

    }