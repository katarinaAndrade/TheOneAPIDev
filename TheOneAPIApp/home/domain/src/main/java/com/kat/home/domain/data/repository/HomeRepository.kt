package com.kat.home.domain.data.repository

import com.kat.home.domain.data.datasource.HomeDataSource
import com.kat.home.domain.data.model.Params
import kotlin.reflect.KClass

class HomeRepository(
    private val dataSource: HomeDataSource
) {

    suspend fun <T> loadData(typeData: String, params: Params?): T? =
        dataSource.loadData(typeData, params)

}