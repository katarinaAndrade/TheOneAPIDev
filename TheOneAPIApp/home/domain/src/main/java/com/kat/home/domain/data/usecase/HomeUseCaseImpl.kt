package com.kat.home.domain.data.usecase

import com.kat.home.domain.data.model.Params
import com.kat.home.domain.data.model.modeltypes.ResponseBook
import com.kat.home.domain.data.repository.HomeRepository
import kotlin.reflect.KClass

class HomeUseCaseImpl(
    private val repository: HomeRepository
): HomeUseCase {

    override suspend fun <T> loadData(typeData: String, params: Params?): T? =
        repository.loadData(typeData, params)

}