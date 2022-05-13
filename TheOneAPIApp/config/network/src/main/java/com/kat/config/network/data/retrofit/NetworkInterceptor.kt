package com.kat.config.network.data.retrofit

import com.kat.config.network.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val buildRequest = chain.request().newBuilder()
        buildRequest.addHeader(Constants.AUTHORIZATION, Constants.BEARER_TOKEN)
        return chain.proceed(buildRequest.build())
    }

}