import config.AppConfig
import dependencies.extension.implementations
import dependencies.AppDependenciesLibs.defaultAppLibs
import dependencies.AppDependenciesLibs.testLibs
import dependencies.AppDependenciesLibs.commonLibs
import dependencies.AppDependenciesLibs.koinLibs
import dependencies.AppDependenciesLibs.lifecycleLibs

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSDK

    defaultConfig {
        applicationId = "com.kat.theoneapi"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementations(defaultAppLibs)
    implementations(testLibs)

    implementations(commonLibs)
    implementations(koinLibs)
    implementations(lifecycleLibs)

    implementation(projects.config.ui)
    implementation(projects.config.navigation)
    implementation(projects.config.network)
    implementation(projects.home.ui)
    implementation(projects.home.domain)
    implementation(projects.details.ui)
    implementation(projects.details.domain)

}