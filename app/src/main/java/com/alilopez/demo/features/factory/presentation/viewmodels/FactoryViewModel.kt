package com.alilopez.demo.features.factory.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.alilopez.demo.features.factory.domain.GetFactoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FactoryViewModel(
    private val getFactoryUseCase: GetFactoryUseCase
) : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun inc() {
        _count.value++
    }
}