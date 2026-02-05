package com.alilopez.demo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alilopez.demo.core.di.AppContainer
import com.alilopez.demo.core.navigation.NavigationWrapper
import com.alilopez.demo.features.counter.presentation.CounterScreen
import com.alilopez.demo.core.ui.theme.AppTheme
import com.alilopez.demo.features.home.navigation.HomeNavGraph
import com.alilopez.demo.features.jsonplaceholder.di.JsonPlaceHolderModule
import com.alilopez.demo.features.jsonplaceholder.navigation.JsonPlaceHolderNavGraph
import com.alilopez.demo.features.rickandmorty.di.CharactersModule
import com.alilopez.demo.features.rickandmorty.navigation.CharactersNavGraph
import com.alilopez.demo.features.rickandmorty.presentation.screens.CharactersScreen

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContainer = AppContainer(this)
        val charactersModule = CharactersModule(appContainer)
        val jsonPlaceHolderModule = JsonPlaceHolderModule(appContainer)
        //val settingsModule = SettingsModule(appContainer) // Otro feature

        val navGraphs = listOf(
            CharactersNavGraph(charactersModule),
            JsonPlaceHolderNavGraph(jsonPlaceHolderModule),
            HomeNavGraph()
        )
        Log.d("Main", "Todo ok")
        enableEdgeToEdge()
        setContent {
            AppTheme {
                NavigationWrapper(navGraphs)
            }
        }
    }
}
