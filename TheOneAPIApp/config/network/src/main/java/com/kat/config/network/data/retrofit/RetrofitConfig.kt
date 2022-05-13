package com.kat.config.network.data.retrofit

import com.kat.config.network.common.Constants
import com.kat.config.network.data.service.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitConfig {

    fun setupOkHttpClient(listInterceptor: List<Interceptor>): OkHttpClient {
        val builder = OkHttpClient().newBuilder().apply {
            readTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
        }
        listInterceptor.forEach {
            builder.addInterceptor(it)
        }
        return builder.build()
    }

    fun setupServiceGeneric(
        httpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): ApiService {
        val builder = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .client(httpClient)
            .addConverterFactory(converterFactory)
        return builder.build().create(ApiService::class.java)
    }

}