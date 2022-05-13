package dependencies

object AppDependenciesLibs {

    val defaultAppLibs = arrayListOf<String>().apply {
        add(AppDependencies.androidCoreKTX)
        add(AppDependencies.appCompat)
        add(AppDependencies.material)
        add(AppDependencies.constraintLayout)
        add(AppDependencies.navigation)
        add(AppDependencies.navigationUI)
    }

    val testLibs = arrayListOf<String>().apply {
        add(AppDependencies.junit)
        add(AppDependencies.androidXJunit)
        add(AppDependencies.androidXEspresso)
    }

    val commonLibs = arrayListOf<String>().apply {
        add(AppDependencies.kotlinStdLib)
        add(AppDependencies.kotlinxCoroutinesCore)
        add(AppDependencies.androidxPreferenceKtx)
        add(AppDependencies.moshi)
        add(AppDependencies.kotlinxSerializationJson)
    }

    val koinLibs = arrayListOf<String>().apply {
        add(AppDependencies.koinCore)
        add(AppDependencies.koinAndroid)
        add(AppDependencies.koinAndroidExt)
        add(AppDependencies.koinExt)
    }

    val lifecycleLibs = arrayListOf<String>().apply {
        add(AppDependencies.lifecycleCommon)
        add(AppDependencies.lifecycleViewModelKtx)
        add(AppDependencies.lifecycleRuntimeKtx)
        add(AppDependencies.lifecycleLiveDataKtx)
    }

    val networkLibs = arrayListOf<String>().apply {
        add(AppDependencies.retrofit)
        add(AppDependencies.okhttp3)
        add(AppDependencies.loggingInterceptor)
        add(AppDependencies.moshi)
        add(AppDependencies.moshiConverter)
        add(AppDependencies.moshiAdapters)
    }

    val googleLibs = arrayListOf<String>().apply {
        add(AppDependencies.googleAuth)
    }

    val firebaseLibs = arrayListOf<String>().apply {
        add(AppDependencies.firebaseAnalytics)
        add(AppDependencies.firebaseCrashlytics)
        add(AppDependencies.firebaseFirestore)
        add(AppDependencies.firebaseStorage)
    }

}