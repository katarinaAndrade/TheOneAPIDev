buildscript {
    repositories {
        google()
        mavenCentral()
    }

    val androidVersion = config.Version.androidVersion
    val kotlinVersion = config.Version.kotlinVersion
    val googleVersion = config.Version.googleServices

    dependencies {
        classpath("com.android.tools.build:gradle:$androidVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.google.gms:google-services:$googleVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}