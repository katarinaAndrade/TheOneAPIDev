package com.kat.theoneapi.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.unloadKoinModules
import org.koin.core.logger.Level

object SetupKoin {

    const val TYPE_START = "START"
    const val TYPE_LOAD_MODULES = "LOAD MODULES"
    const val TYPE_UNLOAD_MODULES = "UNLOAD MODULES"

    fun setupKoin(type: String, context: Context) {
        when(type) {
            TYPE_START -> appStartKoin(context)
            TYPE_LOAD_MODULES -> appLoadKoinModules()
            TYPE_UNLOAD_MODULES -> appUnloadKoinModules()
        }
    }

    private fun appStartKoin(context: Context) {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(context)
            modules(AppKoinModule.startKoinModules)
        }
    }

    private fun appLoadKoinModules(){
        loadKoinModules(AppKoinModule.koinModules)
    }

    private fun appUnloadKoinModules() {
        unloadKoinModules(AppKoinModule.koinModules)
    }

}