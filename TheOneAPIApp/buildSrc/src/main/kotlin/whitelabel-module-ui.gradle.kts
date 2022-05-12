import config.AppConfig
import dependencies.extension.implementations
import dependencies.AppDependenciesLibs.defaultAppLibs
import dependencies.AppDependenciesLibs.testLibs
import dependencies.AppDependenciesLibs.commonLibs
import dependencies.AppDependenciesLibs.koinLibs
import dependencies.AppDependenciesLibs.lifecycleLibs

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSDK

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementations(defaultAppLibs)
    implementations(testLibs)

    implementations(commonLibs)
    implementations(koinLibs)
    implementations(lifecycleLibs)

}