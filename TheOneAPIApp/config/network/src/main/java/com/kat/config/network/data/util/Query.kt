package com.kat.config.network.data.util

import kotlin.reflect.KProperty

class Query {

    private val mHashMap = HashMap<String, String>()

    val hashMap: Map<String, String>
        get() = mHashMap

    fun addToHashMap(key: String, value: String?) {
        value?.let { mHashMap[key] = it }
    }

    fun queryParam(param: String? = null) = QueryParam(param)

    inner class QueryParam(private val name: String? = null) {

        operator fun getValue(ref: Any?, property: KProperty<*>) = mHashMap[name ?: property.name]

        operator fun setValue(ref: Any?, property: KProperty<*>, value: String?) {
            value?.let { mHashMap[name ?: property.name] = it }
        }

    }
}