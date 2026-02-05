package com.alilopez.demo.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alilopez.demo.features.rickandmorty.presentation.screens.CharactersScreen

@Composable
fun NavigationWrapper(
    navGraphs: List<FeatureNavGraph>
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        Log.d("NavigationWrapper","Ok")
        navGraphs.forEach { graph ->
            graph.registerGraph(this, navController)
        }
    }
}