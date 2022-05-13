package com.kat.config.network.data.converter

import android.util.Log
import com.squareup.moshi.Moshi

class AppConverterImpl(private val moshi: Moshi): AppConverter {

    override fun <T> fromJson(json: String?, clazz: Class<T>): T {
        return json?.let{
            try {
                moshi.adapter(clazz).fromJson(json)
            } catch (e: Exception) {
                Log.d(AppConverterImpl::class.simpleName, e.cause.toString())
                throw Exception()
            }
        } ?: throw Exception()
    }

}