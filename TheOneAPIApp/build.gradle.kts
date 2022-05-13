buildscript {
    repositories {
        google()
        mavenCentral()
    }

    val androidVersion = config.Version.androidVersion
    val kotlinVersion = config.Version.kotlinVersion

    dependencies {
        classpath("com.android.tools.build:gradle:$androidVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
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