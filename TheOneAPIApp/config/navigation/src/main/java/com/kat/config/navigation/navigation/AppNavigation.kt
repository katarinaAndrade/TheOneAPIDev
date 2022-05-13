package com.kat.config.navigation.navigation

import android.app.Activity
import android.content.Intent
import android.os.Build
import com.kat.config.navigation.navigation.common.AppLifecycleCallBack
import com.kat.home.ui.base.HomeActivity

class AppNavigation(
    private val appLifecycleCallBack: AppLifecycleCallBack
) {

    fun openHome(activity: Activity) {
        val intent = Intent(activity.applicationContext, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity.startActivity(intent)
        activity.finish()
    }

    fun destroyActivities(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            appLifecycleCallBack.destroyActivities(setOf(activity::class.java))
        } else
            activity.finish()
    }

}