package com.kat.config.network.di

import com.kat.config.network.connection.CheckNetworkConnection
import com.kat.config.network.data.NetworkEngine
import com.kat.config.network.data.converter.AppConverter
import com.kat.config.network.data.converter.AppConverterImpl
import com.kat.config.network.data.retrofit.NetworkInterceptor
import com.kat.config.network.data.retrofit.RetrofitConfig
import com.kat.config.network.data.service.ApiServiceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkKoinModule {

    val networkKoinModule = module {

        single {
            NetworkInterceptor()
        } bind Interceptor::class
        single {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } bind Interceptor::class
        single<Moshi> {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }
        single<Converter.Factory> {
            MoshiConverterFactory.create()
        }
        single {
            RetrofitConfig.setupOkHttpClient(getAll())
        }
        single {
            RetrofitConfig.setupServiceGeneric(get(), get())
        }
        single {
            CheckNetworkConnection(get())
        }
        single<AppConverter> {
            AppConverterImpl(get())
        }
        single<NetworkEngine> {
            ApiServiceImpl(get(), get(), get())
        }

    }

}