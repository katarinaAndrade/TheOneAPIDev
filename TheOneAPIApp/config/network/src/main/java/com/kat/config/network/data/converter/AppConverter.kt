package com.kat.config.network.data.converter

interface AppConverter {

    fun <T> fromJson(json: String?, clazz: Class<T>): T

}