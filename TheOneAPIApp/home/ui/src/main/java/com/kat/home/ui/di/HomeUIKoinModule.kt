package com.kat.home.ui.di

import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.kat.home.ui.screen.sharedviewmodel.viewmodel.HomeViewModel
import com.kat.home.ui.screen.sharedviewmodel.viewmodel.HomeViewModelImpl
import com.kat.home.ui.screen.login.viewmodel.LoginViewModel
import com.kat.home.ui.screen.login.viewmodel.LoginViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeUIKoinModule {

    val homeUIKoinModule = module {
        single {
            Firebase.initialize(get())
        }
        viewModel<HomeViewModel> {
            HomeViewModelImpl(get())
        }
        viewModel<LoginViewModel> {
            LoginViewModelImpl(get())
        }
    }

}