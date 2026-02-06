package com.alilopez.demo.features.factory.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.demo.features.factory.domain.GetFactoryUseCase
import com.alilopez.demo.features.rickandmorty.domain.usecases.GetCharactersUseCase
import com.alilopez.demo.features.rickandmorty.presentation.viewmodels.CharactersViewModel

class FactoryViewModelFactory(
    private val getFactoryUseCase: GetFactoryUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FactoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FactoryViewModel(getFactoryUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}