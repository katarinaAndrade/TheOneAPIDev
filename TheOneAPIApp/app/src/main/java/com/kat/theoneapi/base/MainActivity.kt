package com.kat.theoneapi.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.kat.config.navigation.navigation.AppNavigation
import com.kat.config.navigation.navigation.common.AppLifecycleCallBack
import com.kat.config.network.common.Permission
import com.kat.theoneapi.R
import com.kat.theoneapi.databinding.ActivityMainBinding
import com.kat.theoneapi.di.SetupKoin
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val appLifecycleCallBack: AppLifecycleCallBack by inject()
    private val appNavigation: AppNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            registerActivityLifecycleCallbacks(appLifecycleCallBack)

        window.apply {
            this.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        SetupKoin.setupKoin(type = SetupKoin.TYPE_LOAD_MODULES, context = this)

        Permission.requestPermission(this)
    }

    private fun continueToApp() {
        object: CountDownTimer(2000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                println("$millisUntilFinished")
            }

            override fun onFinish() {
                appNavigation.openHome(this@MainActivity)
            }
        }.start()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        newBase?.let {
            SetupKoin.setupKoin(type = SetupKoin.TYPE_START, context = it)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Permission.REQUEST_PERMISSION_INTERNET
            && Permission.isGrantResultsGranted(grantResults)) continueToApp()
    }

}