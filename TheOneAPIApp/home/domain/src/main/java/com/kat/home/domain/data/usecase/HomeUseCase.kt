package com.kat.home.domain.data.usecase

import com.kat.home.domain.data.model.Params

interface HomeUseCase {

    suspend fun <T> loadData(typeData: String, params: Params?): T?

}