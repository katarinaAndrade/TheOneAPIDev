package com.kat.config.navigation.navigation.common

import android.app.Activity
import android.app.Application
import android.os.Bundle

class AppLifecycleCallBack : Application.ActivityLifecycleCallbacks {

    private val runningActivities = mutableListOf<Activity>()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        runningActivities.add(activity)
    }

    override fun onActivityStarted(activity: Activity) = Unit

    override fun onActivityResumed(activity: Activity) = Unit

    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStopped(activity: Activity) = Unit

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityDestroyed(activity: Activity) {
        runningActivities.remove(activity)
    }

    fun destroyActivities(activities: Set<Class<out Activity>>) {
        runningActivities.forEach {
            if (activities.contains(it.javaClass))
                it.finish()
        }
    }

}