package com.kat.config.network.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.kat.config.network.connection.permission.NetworkPermission

class CheckNetworkConnection(private val context: Context) {

    fun checkNetworkAvailable(): Boolean {
        if(NetworkPermission.verifyPermissionGranted(context)) return false

        val connectivityManager = context.connectivityManager
        val connectivityNetwork = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(connectivityNetwork) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    companion object {
        val Context.connectivityManager: ConnectivityManager
            get() = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

}