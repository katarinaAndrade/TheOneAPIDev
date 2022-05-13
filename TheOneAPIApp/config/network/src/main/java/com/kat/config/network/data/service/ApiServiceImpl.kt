package com.kat.config.network.data.service

import com.kat.config.network.common.Constants
import com.kat.config.network.connection.CheckNetworkConnection
import com.kat.config.network.data.NetworkEngine
import com.kat.config.network.data.converter.AppConverter
import com.kat.config.network.data.util.Query
import com.kat.config.network.data.util.Result
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import kotlin.reflect.KClass

class ApiServiceImpl(
    private val checkNetwork: CheckNetworkConnection,
    private val appConverter: AppConverter,
    private val apiService: ApiService
): NetworkEngine {

    override suspend fun <T : Any> getRequest(
        path: String,
        headers: List<Pair<String, String>>?,
        responseClass: KClass<T>,
        query: Query?
    ): Result<T> {
        return setupRequest(
            path = path,
            headers = headers,
            responseClass = responseClass,
            query = query,
            method = NetworkEngine.Method.GET
        )
    }

    private suspend fun <T : Any> setupRequest(
        path: String,
        headers: List<Pair<String, String>>? = null,
        body: Any? = null,
        responseClass: KClass<T>,
        query: Query?,
        method: NetworkEngine.Method
    ): Result<T> {
        val result = makeRequest(
            path = path,
            body = body,
            headers = headers,
            query = query,
            method = method
        )

        return if (result is Result.Success) {
            val converted = appConverter.fromJson(
                result.data,
                responseClass.java
            )
            Result.Success(converted, result.headerMap)
        } else {
            result as Result<T>
        }
    }

    private suspend fun makeRequest(
        path: String,
        headers: List<Pair<String, String>>? = null,
        body: Any? = null,
        query: Query? = null,
        method: NetworkEngine.Method
    ): Result<String> {
        var completePath = "${Constants.API_URL}$path"
        val hashMapHeader = hashMapOf<String, String>()

        headers?.forEach {
            val (key, value) = it
            hashMapHeader[key] = value
        }

        query?.let {
            completePath = completePath.addQueryParams(it.hashMap)
        } ?: kotlin.run {
            completePath += Constants.TYPE_URL_BAR
        }

        return callApi {
            val response = apiService.getRequest(completePath, hashMapHeader)
            if (response.isSuccessful) {
                val responseBody = response.body()?.string() ?: ""
                Result.Success(responseBody, response.headers().toMap())
            } else
                throw HttpException(response)
        }
    }

    private fun String.addQueryParams(params: Map<String, String>): String {
        var query = ""
        params.forEach { param ->
            query += "${param.key}=${param.value}"
        }
        return "$this${if (query.isNotEmpty()) "?$query" else ""}"
    }

    private suspend fun <T : Any> callApi(call: suspend () -> Result<T>): Result<T> =
        withContext(IO) {
            try {
                if (!checkNetwork.checkNetworkAvailable()) throw IOException()
                call.invoke()
            } catch (t: Throwable) {
                when (t) {
                    is HttpException -> Result.Error(t, null)
                    else -> Result.Error(t, null)
                }
            }
        }

}