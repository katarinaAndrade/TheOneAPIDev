package com.kat.config.network.data

import com.kat.config.network.data.util.Query
import com.kat.config.network.data.util.Result
import kotlin.reflect.KClass

interface NetworkEngine {

    enum class Method {
        GET
    }

    suspend fun <T: Any> getRequest(
        path: String,
        headers: List<Pair<String, String>>? = null,
        responseClass: KClass<T>,
        query: Query? = null
    ): Result<T>

}