package com.kat.home.domain.di

import com.kat.home.domain.data.datasource.HomeDataSource
import com.kat.home.domain.data.repository.HomeRepository
import com.kat.home.domain.data.usecase.HomeUseCase
import com.kat.home.domain.data.usecase.HomeUseCaseImpl
import org.koin.dsl.module

object HomeDomainKoinModule {

    val homeDomainKoinModule = module {
        factory<HomeUseCase> {
            HomeUseCaseImpl(get())
        }
        factory {
            HomeRepository(get())
        }
        factory {
            HomeDataSource(get())
        }
    }

}