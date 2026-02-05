package com.alilopez.demo.features.counter.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountViewModel : ViewModel(){
    private var _count = MutableStateFlow(0)
    var count = _count.asStateFlow()

    fun increment(){
        _count.value++
    }
    fun decrement() {
        _count.value--
    }
}