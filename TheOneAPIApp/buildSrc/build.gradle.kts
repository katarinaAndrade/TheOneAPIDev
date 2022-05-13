import config.Version

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {

    val androidVersion = Version.androidVersion
    val kotlinVersion = Version.kotlinVersion

    implementation("com.android.tools.build:gradle:$androidVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}