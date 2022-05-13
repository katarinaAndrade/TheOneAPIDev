package com.kat.config.network.data.service

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getRequest(
        @Url url: String,
        @HeaderMap header: Map<String, String>
    ) : Response<ResponseBody>

}