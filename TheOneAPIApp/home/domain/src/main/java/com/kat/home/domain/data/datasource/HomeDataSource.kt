package com.kat.home.domain.data.datasource

import com.kat.config.network.data.NetworkEngine
import com.kat.config.network.data.util.Query
import com.kat.config.network.data.util.Result
import com.kat.home.domain.data.Constants
import com.kat.home.domain.data.model.Params
import com.kat.home.domain.data.model.modeltypes.*
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.KTypeProjection
import kotlin.reflect.full.createType

class HomeDataSource(
    private val networkEngine: NetworkEngine
) {

    suspend fun <T> loadData(typeData: String, params: Params?): T? {
        var queryParam: Query? = null
        params?.let {
            queryParam = addQueryParams(it)
        }

        val clazz = when(typeData) {
            Constants.TYPE_SEARCH_BOOK -> ResponseBook::class
            Constants.TYPE_SEARCH_CHARACTER -> ResponseCharacter::class
            Constants.TYPE_SEARCH_MOVIE -> ResponseMovie::class
            else -> ResponseQuote::class
        }

        networkEngine.getRequest(
            path = typeData,
            responseClass = clazz,
            query = queryParam
        ).run {
            return when(this) {
                is Result.Success -> this.data as T?
                is Result.Error -> throw Exception()
            }
        }
    }

    private fun addQueryParams(params: Params): Query =
        Query().apply {
            params.total?.let { this.addToHashMap("total", it) }
            params.limit?.let { this.addToHashMap("limit", it) }
            params.offset?.let { this.addToHashMap("offset", it) }
            params.page?.let { this.addToHashMap("page", it) }
            params.pages?.let { this.addToHashMap("pages", it) }
        }
}