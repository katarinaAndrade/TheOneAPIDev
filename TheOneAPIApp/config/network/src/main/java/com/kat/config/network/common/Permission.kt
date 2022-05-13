package com.kat.config.network.common

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object Permission {

    const val REQUEST_PERMISSION_INTERNET = 0

    fun requestPermission(activity: Activity) {
        activity.requestPermissions(
            arrayOf(
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE
            ),
            REQUEST_PERMISSION_INTERNET
        )
    }

    fun verifyPermissions(context: Context): Boolean {
        val internet = ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET)
        val networkState = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE)
        return internet == PackageManager.PERMISSION_GRANTED && networkState == PackageManager.PERMISSION_GRANTED
    }

    fun isGrantResultsGranted(grantResults: IntArray): Boolean {
        var isGrantResultsGranted = true

        for (grantResult in grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                isGrantResultsGranted = false
                break
            }
        }

        return isGrantResultsGranted
    }

}