package com.alilopez.demo.features.login.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.demo.features.login.domain.usecase.LoginUseCase

class LoginViewModelFactory(
private val loginUseCase : LoginUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel2(useCase = loginUseCase)  as T
    }
}