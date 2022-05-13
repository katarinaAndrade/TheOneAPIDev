package com.kat.config.network.data.util

sealed class Result<out T: Any> {

    data class Success<out T: Any>(val data: T?, val headerMap: Map<String, String>? = null): Result<T>()

    data class Error<out T: Any>(val throwable: Throwable?, val response: T?): Result<T>()

}
