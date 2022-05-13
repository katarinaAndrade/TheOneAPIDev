package com.kat.theoneapi.di

import com.kat.config.navigation.di.NavigationKoinModule
import com.kat.config.navigation.navigation.common.AppLifecycleCallBack
import com.kat.config.network.di.NetworkKoinModule
import com.kat.home.domain.di.HomeDomainKoinModule
import com.kat.home.ui.di.HomeUIKoinModule
import org.koin.dsl.module

object AppKoinModule {

    private val appKoinModule = module {
        single {
            AppLifecycleCallBack()
        }
    }

    val startKoinModules = listOf(
        appKoinModule,
        NetworkKoinModule.networkKoinModule
    )

    val koinModules = listOf(
        NavigationKoinModule.navigationKoinModule,
        HomeDomainKoinModule.homeDomainKoinModule,
        HomeUIKoinModule.homeUIKoinModule
    )

}