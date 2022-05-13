package com.kat.config.navigation.di

import com.kat.config.navigation.navigation.AppNavigation
import com.kat.config.navigation.navigation.screen.HomeNavigationImpl
import com.kat.home.ui.navigation.HomeNavigation
import org.koin.dsl.module

object NavigationKoinModule {

    val navigationKoinModule = module {

        single {
            AppNavigation(get())
        }
        factory<HomeNavigation> {
            HomeNavigationImpl()
        }

    }

}