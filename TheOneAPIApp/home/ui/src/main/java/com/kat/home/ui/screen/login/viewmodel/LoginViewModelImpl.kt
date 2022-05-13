package com.kat.home.ui.screen.login.viewmodel

import com.kat.home.domain.data.usecase.HomeUseCase

class LoginViewModelImpl(
    private val useCase: HomeUseCase
): LoginViewModel() {
}